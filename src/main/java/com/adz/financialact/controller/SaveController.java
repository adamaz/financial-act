package com.adz.financialact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.adz.financialact.common.util.ExceptionUtility;
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
            model.addAttribute("actIsNotOk", ExceptionUtility.getInnerMostExceptionMessage(sqlException));
        }
        catch (JpaSystemException jpaSystemException)
        {
            model.addAttribute("actIsNotOk", ExceptionUtility.getInnerMostExceptionMessage(jpaSystemException));
        }
        catch (org.springframework.dao.DataAccessException dataAccessException)
        {
            model.addAttribute("actIsNotOk", ExceptionUtility.getInnerMostExceptionMessage(dataAccessException));
        }
        catch (Exception exception)
        {
            model.addAttribute("actIsNotOk", ExceptionUtility.getInnerMostExceptionMessage(exception));
        }

        return ViewDefinitions.ACT;
    }
}
