package com.adz.financialact.service;

import com.adz.financialact.entity.*;
import com.adz.financialact.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;

import java.util.List;
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
}
