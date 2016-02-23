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

	<E> List<E> queryForList(String query, Class<E> clazz)  throws RetrievalFailureSystemException;	 
	<E> List<E> queryForList(String query, Object[] args, Class<E> clazz)  throws RetrievalFailureSystemException;	 
	<E> List<E> queryForList(String query, RowMapper<E> mapper) throws RetrievalFailureSystemException;	 
	<E> List<E> queryForList(String query, Object[] args, RowMapper<E> mapper) throws RetrievalFailureSystemException;	 
	<E> List<E> queryForBeanList(String query, Object[] args, Class<E> clazz) throws RetrievalFailureSystemException;	 
	<E> E queryForBean(String query, Object[] args,  Class<E> clazz) throws RetrievalFailureSystemException;	 
	<E> E queryForObject(String query, Object[] args, Class<E> clazz) throws RetrievalFailureSystemException;	 
	<E> E queryForObject(String query, RowMapper<E> mapper) throws RetrievalFailureSystemException;	 
	<E> E queryForObject(String query, Object[] args,  RowMapper<E> mapper) throws RetrievalFailureSystemException;	 
	Map<String, Object> queryForMap(String query, Object[] args) throws RetrievalFailureSystemException;	 
	List< Map<String, Object>> queryForList(String query) throws RetrievalFailureSystemException;	 
	List<Map<String, Object>> queryForList(String query, Object[] args) throws RetrievalFailureSystemException;
}
