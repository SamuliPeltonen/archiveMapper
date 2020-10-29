package hh.swd20.archiveapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.archiveapp.domain.CompanyRepository;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/companylist")
	public String getAllCompanies(Model model) {
		model.addAttribute("companies", companyRepository.findAll());
		return "companies";
	}
}
