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

	//we need to inject ArchiveSetRepository and CompanyRepository to use their CRUD-operations
	@Autowired
	private ArchiveSetRepository archiveSetRepository;

	@Autowired
	private CompanyRepository companyrepository;

	//finds all archivesets from the repo with GET
	@GetMapping("/archivesets")
	public String getAllArchives(Model model) {
		model.addAttribute("archivesets", archiveSetRepository.findAll());
		return "allArchiveSets";
	}
	
	//creates a blank form with fields to create a new ArchiveSet-object
	@GetMapping("/archives/add")
	@PreAuthorize("isAuthenticated()")
	public String addArchive(Model model) {
		ArchiveSet archiveSet = new ArchiveSet();
		archiveSet.setWhenHandled(new Date(System.currentTimeMillis()));
		model.addAttribute("archiveSet", archiveSet);
		model.addAttribute("companies", companyrepository.findAll());
		return "newarchiveset"; // returns the template newarchiveset.html
	}
	
	//saves inputs that have been entered in the fields
	@PostMapping("/savenew")
	public String saveArchive(@Valid ArchiveSet archiveSet, BindingResult bindingResult, Model model) {
		//bindingresult is for form validation and goes to the "if", if the fields are empty upon submitting
		if (bindingResult.hasErrors()) {
			model.addAttribute("archiveSet", archiveSet);
			model.addAttribute("companies", companyrepository.findAll());

			return "newarchiveset"; //when errors are detected, load the newarchiveset-template again(preventing empty form submissions"
		} else {
			if (archiveSet.getWhenHandled() == null) {
				archiveSet.setWhenHandled(new Date(System.currentTimeMillis()));
			}
			//if no errors are detected, redirect to confirm-template
			archiveSetRepository.save(archiveSet);
			return ("confirm");
		}
	}
	//second save method for EDITING, I couldn't think of a more elegant way to return to editarchiveset.html in case of editing
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
	
	//deletes objects from the database
	@GetMapping("archives/delete/{id}")//{id} is the url pathvariable, which changes between objects as all ids are unique
	@PreAuthorize("hasAuthority('ADMIN')")//preauthorize means that this is only available to users with the authority of "ADMIN"
	public String deleteArchiveSet(@PathVariable("id") Long archiveId, Model model) {
		archiveSetRepository.deleteById(archiveId);
		return "redirect:/archivesets";
	}

	//edits objects, available to anyone logged in
	@GetMapping("update/{id}")
	@PreAuthorize("isAuthenticated()")
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
	//returns the login page
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
}
