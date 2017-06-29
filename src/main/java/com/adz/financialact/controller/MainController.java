package com.adz.financialact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.adz.financialact.common.util.ViewDefinitions;

@Controller
public class MainController
{
	@GetMapping(value="/")
	public String index()
	{
		return ViewDefinitions.HOME;
	}
	
	@GetMapping(value="/act")
	public String showAct()
	{
		return ViewDefinitions.ACT;
	}
	
	@GetMapping(value="/values")
	public String showValue()
	{
		return ViewDefinitions.VALUES;
	}
}