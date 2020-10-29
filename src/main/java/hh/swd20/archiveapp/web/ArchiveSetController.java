package hh.swd20.archiveapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.archiveapp.domain.ArchiveSetRepository;
import hh.swd20.archiveapp.domain.CompanyRepository;

@Controller
public class ArchiveSetController {

	@Autowired
	private ArchiveSetRepository archiveSetRepository;
	
	@Autowired
	private CompanyRepository companyrepository;
	
	@GetMapping("/archives")
	public String getAllArchives(Model model) {
		model.addAttribute("archivesets", archiveSetRepository.findAll());
		return "allArchiveSets";
	}
	
}
