package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= {"aboutus"} ) // Controller mac dinh
public class AboutusController {
	@RequestMapping(method= RequestMethod.GET)
	public String index() {
		return "aboutus.index"; // tiles.xml
	}
}