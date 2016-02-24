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
import com.rsinc.webretail.b2c.estore.data.entity.BaseBean;

/**
 * @author Roshan Titus
 *
 */
@Component
public interface BaseEntityManager <T extends BaseBean> {

	//ORM using JPA

	/**
	 * 
	 * @param t
	 */
	void setDefaultValues(T t);

	/**
	 * 
	 * @param t
	 * @throws ValidationException
	 */
	void validateForCreate(T t) throws ValidationException;

	/**
	 * 
	 * @param t
	 * @throws ValidationException
	 */
	void validateForUpdate(T t) throws ValidationException;

	/**
	 * 
	 * @param t
	 * @throws ValidationException
	 */
	void validateForDelete(T t) throws ValidationException;

	/**
	 * 
	 * @param t
	 * @return
	 * @throws PersistanceFailureSystemException
	 * @throws RecordAlreadyExistsException
	 * @throws ValidationException
	 */
	T create(T t) throws PersistanceFailureSystemException,
			RecordAlreadyExistsException, ValidationException;

	/**
	 * 
	 * @param t
	 * @return
	 * @throws PersistanceFailureSystemException
	 * @throws ValidationException
	 */
	T update(T t) throws PersistanceFailureSystemException, ValidationException;

	/**
	 * 
	 * @param t
	 * @throws PersistanceFailureSystemException
	 * @throws ValidationException
	 */
	void delete(T t) throws PersistanceFailureSystemException,
			ValidationException;

	/**
	 * 
	 * @param id
	 * @throws PersistanceFailureSystemException
	 * @throws RecordNotFoundException
	 * @throws ValidationException
	 */
	void deleteById(Object id) throws PersistanceFailureSystemException,
			RecordNotFoundException, ValidationException;

	/**
	 * 
	 * @param entities
	 * @return
	 * @throws PersistanceFailureSystemException
	 * @throws RecordAlreadyExistsException
	 * @throws ValidationException
	 */
	List<T> bulkCreate(List<T> entities)
			throws PersistanceFailureSystemException,
			RecordAlreadyExistsException, ValidationException;

	/**
	 * 
	 * @param entities
	 * @return
	 * @throws PersistanceFailureSystemException
	 * @throws ValidationException
	 */
	List<T> bulkUdate(List<T> entities)
			throws PersistanceFailureSystemException, ValidationException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws RetrievalFailureSystemException
	 * @throws RecordNotFoundException
	 * @throws ValidationException
	 */
	T loadById(Object id) throws RetrievalFailureSystemException,
			RecordNotFoundException, ValidationException;

	/**
	 * 
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findAll() throws RetrievalFailureSystemException;
	
	/**
	 * 
	 * @param queryName
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findWithNamedQuery(String queryName)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param queryName
	 * @param params
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findWithNamedQuery(String queryName, Map<String, Object> params)
			throws RetrievalFailureSystemException;

	/**
	 * @param namedQueryName
	 * @param params
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findWithNamedQuery(String namedQueryName, List params)
			throws RetrievalFailureSystemException;
	/**
	 * @param queryName
	 * @param resultLimit
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findWithNamedQuery(String queryName, int resultLimit)
			throws RetrievalFailureSystemException;
	/**
	 * @param namedQueryName
	 * @param params
	 * @param resultLimit
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findWithNamedQuery(String namedQueryName, Map params,
			int resultLimit) throws RetrievalFailureSystemException;
	/**
	 * @param namedQueryName
	 * @param params
	 * @param resultLimit
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findWithNamedQuery(String namedQueryName, List params,
			int resultLimit) throws RetrievalFailureSystemException;
	/**
	 * @param sql
	 * @param type
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List findByNativeQuery(String sql, Class type)
			throws RetrievalFailureSystemException;
	/**
	 * @param sql
	 * @param type
	 * @param params
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List findByNativeQuery(String sql, Class type, List params)
			throws RetrievalFailureSystemException;
	/**
	 * @param sql
	 * @param type
	 * @param params
	 * @param resultLimit
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List findByNativeQuery(String sql, Class type, List params, int resultLimit)
			throws RetrievalFailureSystemException;	

	//Simple JDBC

	/**
	 * 
	 * @param query
	 * @param clazz
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> List<E> queryForList(String query, Class<E> clazz)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @param clazz
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> List<E> queryForList(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param mapper
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> List<E> queryForList(String query, RowMapper<E> mapper)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @param mapper
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> List<E> queryForList(String query, Object[] args, RowMapper<E> mapper)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @param clazz
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> List<E> queryForBeanList(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @param clazz
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> E queryForBean(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @param clazz
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> E queryForObject(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param mapper
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> E queryForObject(String query, RowMapper<E> mapper)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @param mapper
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	<E> E queryForObject(String query, Object[] args, RowMapper<E> mapper)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	Map<String, Object> queryForMap(String query, Object[] args)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<Map<String, Object>> queryForList(String query)
			throws RetrievalFailureSystemException;

	/**
	 * 
	 * @param query
	 * @param args
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<Map<String, Object>> queryForList(String query, Object[] args)
			throws RetrievalFailureSystemException;
	
}
