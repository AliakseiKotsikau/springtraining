package by.tibon.springtraining.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.tibon.springtraining.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService service;

	public OwnerController(OwnerService service) {
		super();
		this.service = service;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listOfOwners(Model model) {
		model.addAttribute("owners", service.findAll());
		return "owner/index";
	}
}
