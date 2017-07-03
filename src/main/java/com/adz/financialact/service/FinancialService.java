package com.adz.financialact.service;

import com.adz.financialact.common.bean.Stats;
import com.adz.financialact.common.bean.ValueResult;
import com.adz.financialact.entity.*;
import com.adz.financialact.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;

import java.util.List;
import java.util.stream.Collectors;
import java.sql.SQLException;

/**
 * todo document
 *
 */
@Service
@Transactional
public class FinancialService implements FinancialServiceInterface
{
	@Autowired
	private ActRepository actRepository;

	@Autowired
	private ValueRepository valueRepository;

	/**
	 * @see FinancialServiceInterface
	 */
	public boolean saveActEntity(ActEntity actEntity) throws SQLException, JpaSystemException, DataAccessException
	{
		boolean isOk = true;
		actRepository.save(actEntity);

		// Handle isOk and throw custom exception

		return isOk;
	}

	/**
	 * @see FinancialServiceInterface
	 */
	public boolean saveValueEntity(ValueEntity valueEntity) throws SQLException, JpaSystemException, DataAccessException
	{
		boolean isOk = true;
		valueRepository.save(valueEntity);

		// Handle isOk and throw custom exception

		return isOk;
	}

	/**
	 * @see FinancialServiceInterface
	 */
	public List<Stats> getActStats()
	{
		List<Stats> stats = actRepository.getActStats();
		return stats;
	}

	/**
	 * @see FinancialServiceInterface
	 */
	public List<Stats> getValueStats()
	{
		List<Stats> stats = valueRepository.getValueStats();
		return stats;
	}

	/**
	 * @see FinancialServiceInterface
	 */
	public List<ValueResult> getResultsByDate(String pValueDate)
	{
		List<ValueResult> valueResults = valueRepository.getValueResults();

		// Play with streams
		List<ValueResult> resultsByDate = valueResults
											.stream() 								 			// convert list to stream
											.filter(rv -> pValueDate.equals(rv.getValueDate())) // Filter by 'Date'
											.collect(Collectors.toList()); 		 				// Return results as list

		return resultsByDate;
	}

	/**
	 * @see FinancialServiceInterface
	 */
	public List<ValueResult> getResultsByValueNumber(String pValueNumber)
	{
		List<ValueResult> valueResults = valueRepository.getValueResults();

		List<ValueResult> resultsByValueNumber = valueResults
													.stream() 					 							// convert list to stream
													.filter(rv -> pValueNumber.equals(rv.getValueNumber())) // Filter by 'Value Number'
													.collect(Collectors.toList()); 		 					// Return results as list

		return resultsByValueNumber;
	}
}
