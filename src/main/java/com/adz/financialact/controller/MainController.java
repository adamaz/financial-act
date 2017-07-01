package com.adz.financialact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.adz.financialact.common.util.ViewDefinitions;
import com.adz.financialact.entity.*;

@Controller
public class MainController
{
	@GetMapping(value="/")
	public String index()
	{
		return ViewDefinitions.HOME;
	}
	
	@GetMapping(value="/act")
	public String showAct(ActEntity actEntity)
	{
		return ViewDefinitions.ACT;
	}
	
	@GetMapping(value="/value")
	public String showValue(ValueEntity valueEntity)
	{
		return ViewDefinitions.VALUE;
	}
}
