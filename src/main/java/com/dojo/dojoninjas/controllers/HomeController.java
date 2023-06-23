package com.dojo.dojoninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.dojoninjas.services.DojoService;
import com.dojo.dojoninjas.services.NinjaService;

@Controller
public class HomeController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public HomeController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allNinjas", ninjaService.getAll());
		model.addAttribute("allDojos", dojoService.getAll());
		return "main/index.jsp";
	}
}
