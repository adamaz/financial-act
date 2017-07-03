package com.adz.financialact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.NamedNativeQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * todo document
 *
 */
@Entity
@Table(name = "FINVALUES")
@NamedNativeQuery(name="ValueEntity.getValueStats", query="SELECT to_char(VALUE_DATE, 'YYYY-MM') as dateMonth, SUM(AMOUNT) as totalAmount, COUNT(VALUE_ID) as totalEntries FROM FINVALUES GROUP BY to_char(VALUE_DATE, 'YYYY-MM') ORDER BY dateMonth DESC", resultSetMapping="StatsMapping")
public class ValueEntity
{
	/*****************************
	 * PRIVATE ATTRIBUTES
	 *****************************/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VALUE_ID", length = 15)
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "NO_VALUE", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Value Number is empty!")
	@NotNull
	private String valueNumber;

	@Column(name = "AMOUNT", length = 15, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Amount is empty!")
	@NotNull
	private String amount;
	
	@Column(name = "TYPE", length = 200, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Value Type is empty!")
	@NotNull
	private String type;

	@Column(name = "VALUE_DATE", nullable = false)
	@Getter
	@Setter
	private java.sql.Date valueDate;

	@Column(name = "VALUE_ORDER", length = 200, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Order is empty!")
	@NotNull
	private String order;

	@Column(name = "BENEF", length = 200, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Beneficiary is empty!")
	@NotNull
	private String beneficiary;

	@Column(name = "ACCTBENEF", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Beneficiary Account is empty!")
	@NotNull
	private String beneficiaryAccount;

	@Column(name = "REFERENCE", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Reference is empty!")
	@NotNull
	private String reference;

	@Column(name = "BANK", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "Bank is empty!")
	@NotNull
	private String bank;
	
	/*****************************
	 * DEFAULT CONSTRUCTOR
	 *****************************/
	
	public ValueEntity() {}
}
