/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordAlreadyExistsException;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao;
import com.rsinc.webretail.b2c.estore.data.dao.QueryDao;
import com.rsinc.webretail.b2c.estore.data.entity.BaseBean;

/**
 * @author Roshan Titus
 *
 */
@Component
public interface BaseEntityManager <T extends BaseBean> {

	//ORM using JPA
	PersistanceDao<T> getPersistanceDao();
	void setDefaultValues(T t);

	void validateForCreate(T t) throws ValidationException;
	void validateForUpdate(T t) throws ValidationException;
	void validateForDelete(T t) throws ValidationException;	
	
	T create(T t) throws PersistanceFailureSystemException, RecordAlreadyExistsException, ValidationException;
	T update(T t) throws PersistanceFailureSystemException, ValidationException;
	void delete(T t) throws PersistanceFailureSystemException, ValidationException;
	void deleteById(Object id) throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException;	
	void deleteById(Class<T> type, Object id) throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException;	
	List<T> bulkCreate(List<T> entities) throws PersistanceFailureSystemException, RecordAlreadyExistsException, ValidationException;
	List<T> bulkUdate(List<T> entities) throws PersistanceFailureSystemException, ValidationException;		
	
	T load(Class<T> type, Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException;	
	T loadById(Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException;
	
	List<T> findAll() throws RetrievalFailureSystemException;

	//Simple JDBC
	QueryDao getQueryDao();
	
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
