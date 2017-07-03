package com.adz.financialact.common.bean;

import lombok.Getter;
import lombok.Setter;

public class ValueResult
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

	@Getter
	@Setter
	private String 	label;

	@Getter
	@Setter
	private Long 	amount;

	@Getter
	@Setter
	private String 	type;

	@Getter
	@Setter
	private String 	bank;
	
	/*****************************
	 * CONSTRUCTORS
	 *****************************/

	public ValueResult() {}
	
	public ValueResult(String pValueDate, String pValueNumber, String pLabel, Long pAmount, String pType, String pBank)
	{
		this.valueDate 		= pValueDate;
		this.valueNumber 	= pValueNumber;
		this.label 			= pLabel;
		this.amount 		= pAmount;
		this.type 			= pType;
		this.bank 			= pBank;
	}
}
