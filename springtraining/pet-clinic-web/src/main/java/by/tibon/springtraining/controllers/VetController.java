package by.tibon.springtraining.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.tibon.springtraining.services.VetService;

@Controller
public class VetController {

	private final VetService service;

	public VetController(VetService service) {
		super();
		this.service = service;
	}

	@RequestMapping({ "/vets", "/vets/index", "/vets/index.html", "/vets.html" })
	public String listOfVets(Model model) {
		model.addAttribute("vets", service.findAll());
		return "vet/index";
	}
}
