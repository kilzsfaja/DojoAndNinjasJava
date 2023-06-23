package com.dojo.dojoninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojo.dojoninjas.models.Dojo;
import com.dojo.dojoninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/create")
	public String createDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "dojo/dojo.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "dojo/dojo.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showOneDojo(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoService.findOne(id));
		return "dojo/showOne.jsp";
	}
}
