package com.adz.financialact.controller;

import com.adz.financialact.common.util.ViewDefinitions;
import com.adz.financialact.service.FinancialServiceInterface;
import com.adz.financialact.entity.*;
import com.adz.financialact.common.bean.Stats;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

/**
 * todo document
 *
 */
@Controller
public class StatsController
{
	@Autowired
	FinancialServiceInterface financialService;

	@GetMapping("/actstats")
    public String showActStats(Model model)
    {
        List<Stats> actStats = financialService.getActStats();

        model.addAttribute("statsTitle", "Act Stats");
        model.addAttribute("stats", actStats);

        return ViewDefinitions.STATS;
    }

    @GetMapping("/valuestats")
    public String showValueStats(Model model)
    {
        List<Stats> valueStats = financialService.getValueStats();

        model.addAttribute("statsTitle", "Value Stats");
        model.addAttribute("stats", valueStats);

        return ViewDefinitions.STATS;
    }
}
