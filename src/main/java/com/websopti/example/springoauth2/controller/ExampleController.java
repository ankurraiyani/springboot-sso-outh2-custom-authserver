package com.websopti.example.springoauth2.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@RequestMapping("/")
	public String email(Principal principal) {
		System.out.println(" >>>> Inside hello <<<< " + principal.getName());
		return "Hello " + principal.getName();
	}
}
