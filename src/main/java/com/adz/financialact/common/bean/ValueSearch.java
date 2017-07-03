package com.adz.financialact.common.bean;

import lombok.Getter;
import lombok.Setter;

public class ValueSearch
{
	/*****************************
	 * PRIVATE ATTRIBUTES
	 *****************************/

	@Getter
	@Setter
	private String 	valueDate;
	
	@Getter
	@Setter
	private String 	valueNumber;
	
	/*****************************
	 * DEFAULT CONSTRUCTOR
	 *****************************/
	
	public ValueSearch() {}
	
	/*****************************
	 * CONSTRUCTOR
	 *****************************/
	
	public ValueSearch(String pValueDate, String pValueNumber)
	{
		this.valueDate 		= pValueDate;
		this.valueNumber 	= pValueNumber;
	}
}
