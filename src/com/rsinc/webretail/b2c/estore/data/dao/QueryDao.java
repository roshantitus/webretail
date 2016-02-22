/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;

/**
 * @author Roshan Titus
 *
 */
@Repository
public interface QueryDao {

	<T> List <T> queryForList(String query, Class T)  throws RetrievalFailureSystemException;
	 
	<T> List <T> queryForList(String query, Object[] args, Class t)  throws RetrievalFailureSystemException;
	 
	<T> List <T> queryForList(String query, RowMapper<T> mapper) throws RetrievalFailureSystemException;
	 
	<T> List <T> queryForList(String query, Object[] args, RowMapper<T> mapper) throws RetrievalFailureSystemException;
	 
	<T> List <T> queryForBeanList(String query, Object[] args, Class T) throws RetrievalFailureSystemException;
	 
	<T> T queryForBean(String query, Object[] args,  Class T) throws RetrievalFailureSystemException;
	 
	<T> T queryForObject(String query, Object[] args, Class T) throws RetrievalFailureSystemException;
	 
	<T> T queryForObject(String query, RowMapper<T> mapper) throws RetrievalFailureSystemException;
	 
	<T> T queryForObject(String query, Object[] args,  RowMapper<T> mapper) throws RetrievalFailureSystemException;
	 
	Map<String, Object> queryForMap(String query, Object[] args) throws RetrievalFailureSystemException;
	 
	List< Map<String, Object>> queryForList(String query) throws RetrievalFailureSystemException;
	 
	List<Map<String, Object>> queryForList(String query, Object[] args) throws RetrievalFailureSystemException;
}
