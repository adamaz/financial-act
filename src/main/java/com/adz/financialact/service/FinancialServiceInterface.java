package com.adz.financialact.service;

import com.adz.financialact.common.bean.Stats;
import com.adz.financialact.common.bean.ValueResult;
import com.adz.financialact.entity.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;

import java.util.List;
import java.sql.SQLException;

/**
 * todo document
 *
 */
public interface FinancialServiceInterface
{
	/**
	 * Save Act entity
	 * @param actEntity
	 * 
	 * @return true if the entity has been successfully saved into the database, false otherwise
	 */
	public boolean saveActEntity(ActEntity actEntity) throws SQLException, JpaSystemException, DataAccessException;

	/**
	 * Save Value entity
	 * @param valueEntity
	 * 
	 * @return true if the entity has been successfully saved into the database, false otherwise
	 */
	public boolean saveValueEntity(ValueEntity valueEntity) throws SQLException, JpaSystemException, DataAccessException;

	// todo document
	public List<Stats> getActStats();

	// todo document
	public List<Stats> getValueStats();

	// todo document
	public List<ValueResult> getResultsByDate(String pValueDate);

	// todo document
	public List<ValueResult> getResultsByValueNumber(String pValueNumber);
}
