package com.adz.financialact.repository;

import com.adz.financialact.common.bean.Stats;
import com.adz.financialact.common.bean.ValueResult;
import com.adz.financialact.entity.ValueEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * todo document
 *
 */
@Repository
public interface ValueRepository extends JpaRepository<ValueEntity, Long>
{
	// todo document
	public List<ValueEntity> findAll();

	// todo document
	public List<Stats> getValueStats();

	// todo document
	public List<ValueResult> getValueResults();

	// todo document
	//public List<ValueResult> getResultsByValueNumber();
}
