package com.adz.financialact.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * todo document
 *
 */
public class ErrorUtility
{
	/*****************************
	 * STATIC CLASS METHODS
	 *****************************/

	/**
	 * Return the innermost cause message of an exception
	 * 
	 * @param pException caught
	 */
	public static String getInnerMostExceptionMessage(Exception pException)
    {
        String lMessage = "";
        Throwable lException;

        lMessage = pException.getClass().getSimpleName() + ", " + pException.getMessage();
        lException = pException.getCause();
        while (lException != null)
        {
            lMessage = lException.getClass().getSimpleName() + ", " + lException.getMessage();
            lException = lException.getCause();
        }

        return lMessage;
    }

    /**
     * Return error messages caught from form BindingResult
     * 
     * @param pBindingResult
     */
    public static String getBindingResultErrorMessages(BindingResult pBindingResult)
    {
        String errorMessages = "";

        List<FieldError> errors = pBindingResult.getFieldErrors();
        for (FieldError error : errors ) {
            errorMessages += "* " + error.getDefaultMessage() + "\n";
        }

        return errorMessages;
    }
}
