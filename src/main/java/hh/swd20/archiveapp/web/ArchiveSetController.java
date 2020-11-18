package hh.swd20.archiveapp.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.archiveapp.domain.ArchiveSet;
import hh.swd20.archiveapp.domain.ArchiveSetRepository;
import hh.swd20.archiveapp.domain.CompanyRepository;

@CrossOrigin
@Controller
public class ArchiveSetController {

	@Autowired
	private ArchiveSetRepository archiveSetRepository;

	@Autowired
	private CompanyRepository companyrepository;

	@GetMapping("/archivesets")
	public String getAllArchives(Model model) {
		model.addAttribute("archivesets", archiveSetRepository.findAll());
		return "allArchiveSets";
	}
	
	
	@GetMapping("/archives/add")
	@PreAuthorize("isAuthenticated()")
	public String addArchive(Model model) {
		ArchiveSet archiveSet = new ArchiveSet();
		archiveSet.setWhenHandled(new Date(System.currentTimeMillis()));
		model.addAttribute("archiveSet", archiveSet);
		model.addAttribute("companies", companyrepository.findAll());
		return "newarchiveset";
	}

	@PostMapping("/savenew")
	public String saveArchive(@Valid ArchiveSet archiveSet, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("archiveSet", archiveSet);
			model.addAttribute("companies", companyrepository.findAll());

			return "newarchiveset";
		} else {
			if (archiveSet.getWhenHandled() == null) {
				archiveSet.setWhenHandled(new Date(System.currentTimeMillis()));
			}

			archiveSetRepository.save(archiveSet);
			return ("confirm");
		}
	}

	@PostMapping("/saveedit")
	public String saveEdit(@Valid ArchiveSet archiveSet, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("archiveset", archiveSet);
			model.addAttribute("companies", companyrepository.findAll());
			return "editArchiveset";
		} else {
			if (archiveSet.getWhenHandled() == null) {
				archiveSet.setWhenHandled(new Date(System.currentTimeMillis()));
			}

			archiveSetRepository.save(archiveSet);
			return ("confirm");
		}
	}
	@GetMapping("archives/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteArchiveSet(@PathVariable("id") Long archiveId, Model model) {
		archiveSetRepository.deleteById(archiveId);
		return "redirect:/archivesets";
	}

	@GetMapping("update/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editArchive(@PathVariable("id") Long archiveId, Model model) {
		model.addAttribute("archiveSet", archiveSetRepository.findById(archiveId));
		model.addAttribute("companies", companyrepository.findAll());
		return "editArchiveset";
	}

	// Rest-controller for listing all archivesets
	@GetMapping("/archives")
	public @ResponseBody List<ArchiveSet> allArchivesRest() {
		return (List<ArchiveSet>) archiveSetRepository.findAll();

	}

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
}
