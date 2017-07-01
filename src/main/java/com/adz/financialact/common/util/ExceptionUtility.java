package com.adz.financialact.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * todo document
 *
 */
public class ExceptionUtility
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
}
