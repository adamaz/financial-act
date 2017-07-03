package com.adz.financialact.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.adz.financialact.common.bean.Stats;
import com.adz.financialact.entity.ActEntity;

/**
 * todo document
 *
 */
@Repository
public interface ActRepository extends JpaRepository<ActEntity, Long>
{
	// todo document
	public List<ActEntity> findAll();

	// todo document
	public List<Stats> getActStats();
}
