package hh.swd20.archiveapp.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.archiveapp.domain.Company;
import hh.swd20.archiveapp.domain.CompanyRepository;

@CrossOrigin
@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/companylist")
	public String getAllCompanies(Model model) {
		model.addAttribute("companies", companyRepository.findAll());
		return "companies";
	}
	//adds new (blank) company-object
	@GetMapping("/archives/addcompany")
	public String newCompany(Model model) {
		model.addAttribute("company", new Company());
		return "newcompany";
	}
	//saves the previously blank object with the inputs added to the form
	//validation functions in the same way as it did in the ArchiveSetController
	@PostMapping("/savecompany")
	public String saveCompany(@Valid Company company, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("company", company);
			return "newcompany";
		}else {
			companyRepository.save(company);
			return "confirm";
		}
	}
}
