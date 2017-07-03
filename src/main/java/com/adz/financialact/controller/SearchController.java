package com.adz.financialact.controller;

import com.adz.financialact.common.util.ViewDefinitions;
import com.adz.financialact.service.FinancialServiceInterface;
import com.adz.financialact.entity.*;
import com.adz.financialact.common.bean.ValueSearch;
import com.adz.financialact.common.bean.ValueResult;

import javax.validation.Valid;

import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;

/**
 * todo document
 *
 */
@Controller
public class SearchController
{
	@Autowired
	FinancialServiceInterface financialService;

	@GetMapping(value="/search")
	public String showSearchForm(ValueSearch pValueSearch)
	{
		return ViewDefinitions.SEARCH_VALUES;
	}

    @PostMapping("/search")
    public String displaySearchResults(@Valid ValueSearch pValueSearch, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            return ViewDefinitions.SEARCH_VALUES;
        }

        // Search by 'Date'
        List<ValueResult> resultsByDate = new ArrayList<ValueResult>();

        if (!pValueSearch.getValueDate().equals(""))
        {
            resultsByDate = financialService.getResultsByDate(pValueSearch.getValueDate());
        }

        // Search by 'Value Number'
        List<ValueResult> resultsByValueNumber = new ArrayList<ValueResult>();

        if (!pValueSearch.getValueNumber().equals(""))
        {
            resultsByValueNumber = financialService.getResultsByValueNumber(pValueSearch.getValueNumber());
        }

        model.addAttribute("resultsByDate",  		resultsByDate);
        model.addAttribute("resultsByValueNumber", 	resultsByValueNumber);

        return ViewDefinitions.SEARCH_VALUES;
    }
}
