package com.accolite.au.project.boardroombooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	@RequestMapping(value="/wel")
	public String get(Model model) {
		return "welcome";
	}
	
}
