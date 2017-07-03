package com.adz.financialact.common.bean;

import lombok.Getter;
import lombok.Setter;

public class Stats
{
	/*****************************
	 * PRIVATE ATTRIBUTES
	 *****************************/

	@Getter
	@Setter
	private String 	dateMonth;
	
	@Getter
	@Setter
	private Long 	totalAmount;
	
	@Getter
	@Setter
	private Long 	totalEntries;
	
	/*****************************
	 * CONSTRUCTOR
	 *****************************/
	
	public Stats(String pDateMonth, Long pTotalAmount, Long pTotalEntries)
	{
		this.dateMonth 		= pDateMonth;
		this.totalAmount 	= pTotalAmount;
		this.totalEntries 	= pTotalEntries;
	}
}
