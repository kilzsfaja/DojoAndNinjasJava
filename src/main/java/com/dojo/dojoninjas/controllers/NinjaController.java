package com.dojo.dojoninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojo.dojoninjas.models.Ninja;
import com.dojo.dojoninjas.services.DojoService;
import com.dojo.dojoninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/create")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoService.getAll());
		return "ninja/create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("allDojos", dojoService.getAll());
			return "ninja/create.jsp";
		}
		ninjaService.create(ninja);
		return "redirect:/";
	}
}
