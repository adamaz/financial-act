package com.adz.financialact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.adz.financialact.common.util.ErrorUtility;
import com.adz.financialact.common.util.ViewDefinitions;
import com.adz.financialact.service.FinancialServiceInterface;
import com.adz.financialact.entity.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import java.sql.SQLException;

/**
 * todo document
 *
 */
@Controller
public class SaveController
{
	@Autowired
	FinancialServiceInterface financialService;

	@PostMapping("/act")
    public String saveAct(@Valid ActEntity actEntity, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            return ViewDefinitions.ACT;
        }

        try
        {
            // Save into database
            boolean isOk = financialService.saveActEntity(actEntity);
            // log = false ... + throw custom exception

            model.addAttribute("actIsOk", "Act saved successfully!");
            return ViewDefinitions.HOME;
        }
        catch (SQLException sqlException)
        {
            model.addAttribute("actIsNotOk", ErrorUtility.getInnerMostExceptionMessage(sqlException));
        }
        catch (JpaSystemException jpaSystemException)
        {
            model.addAttribute("actIsNotOk", ErrorUtility.getInnerMostExceptionMessage(jpaSystemException));
        }
        catch (org.springframework.dao.DataAccessException dataAccessException)
        {
            model.addAttribute("actIsNotOk", ErrorUtility.getInnerMostExceptionMessage(dataAccessException));
        }
        catch (Exception exception)
        {
            model.addAttribute("actIsNotOk", ErrorUtility.getInnerMostExceptionMessage(exception));
        }

        return ViewDefinitions.ACT;
    }

    @PostMapping("/value")
    public String saveValue(@Valid ValueEntity valueEntity, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("valueIsNotOk", ErrorUtility.getBindingResultErrorMessages(bindingResult));
            return ViewDefinitions.VALUE;
        }

        try
        {
            // Save into database
            boolean isOk = financialService.saveValueEntity(valueEntity);
            // log = false ... + throw custom exception

            System.out.println("Value saved ok");

            model.addAttribute("valueIsOk", "Value saved successfully!");
            return ViewDefinitions.HOME;
        }
        catch (SQLException sqlException)
        {
            model.addAttribute("valueIsNotOk", ErrorUtility.getInnerMostExceptionMessage(sqlException));
        }
        catch (JpaSystemException jpaSystemException)
        {
            model.addAttribute("valueIsNotOk", ErrorUtility.getInnerMostExceptionMessage(jpaSystemException));
        }
        catch (org.springframework.dao.DataAccessException dataAccessException)
        {
            model.addAttribute("valueIsNotOk", ErrorUtility.getInnerMostExceptionMessage(dataAccessException));
        }
        catch (Exception exception)
        {
            model.addAttribute("valueIsNotOk", ErrorUtility.getInnerMostExceptionMessage(exception));
        }

        return ViewDefinitions.VALUE;
    }
}
