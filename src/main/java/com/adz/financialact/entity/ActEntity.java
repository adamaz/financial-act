package com.adz.financialact.entity;

import com.adz.financialact.common.bean.Stats;

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

import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;
import javax.persistence.NamedNativeQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * todo document
 *
 */
@Entity
@Table(name = "FINACT")
@SqlResultSetMapping(name = "StatsMapping",
					 classes = @ConstructorResult(
        				targetClass = Stats.class,
			        	columns = {
			            	@ColumnResult(name = "dateMonth"),
			            	@ColumnResult(name = "totalAmount", type = Long.class),
			            	@ColumnResult(name = "totalEntries", type = Long.class)
			        	}
					)
)
@NamedNativeQuery(name="ActEntity.getActStats", query="SELECT to_char(ACT_DATE, 'YYYY-MM') as dateMonth, SUM(AMOUNT) as totalAmount, COUNT(ACT_ID) as totalEntries FROM FINACT GROUP BY to_char(ACT_DATE, 'YYYY-MM') ORDER BY dateMonth DESC", resultSetMapping="StatsMapping")
public class ActEntity
{
	/*****************************
	 * PRIVATE ATTRIBUTES
	 *****************************/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ACT_ID", length = 20)
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "CLIENT", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Client' is empty!")
	@NotNull
	private String client;

	@Column(name = "REFERENCE", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Reference' is empty!")
	@NotNull
	private String reference;
	
	@Column(name = "OBJECT", length = 200, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Object' is empty!")
	@NotNull
	private String object;

	@Column(name = "DESCRIPTION", length = 200, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Description' is empty!")
	@NotNull
	private String description;

	@Column(name = "BANK", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Bank' is empty!")
	@NotNull
	private String bank;

	@Column(name = "AMOUNT", length = 15, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Amount' is empty!")
	@NotNull
	private String amount;

	@Column(name = "ACT_DATE", nullable = false)
	@Getter
	@Setter
	private java.sql.Date actDate;

	@Column(name = "NATURE", length = 20, nullable = false)
	@Getter
	@Setter
	@NotEmpty(message = "'Nature' is empty!")
	@NotNull
	private String nature;
	
	/*****************************
	 * DEFAULT CONSTRUCTOR
	 *****************************/
	
	public ActEntity() {}
}
