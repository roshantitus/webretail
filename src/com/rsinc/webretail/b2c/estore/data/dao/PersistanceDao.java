/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordAlreadyExistsException;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public interface PersistanceDao<T> {

	/**
	 * 
	 * @param t
	 * @return
	 * @throws PersistanceFailureSystemException
	 * @throws RecordAlreadyExistsException
	 */
	T create(T t) throws PersistanceFailureSystemException,
			RecordAlreadyExistsException;

	/**
	 * 
	 * @param t
	 * @return
	 * @throws PersistanceFailureSystemException
	 */
	T update(T t) throws PersistanceFailureSystemException;

	/**
	 * 
	 * @param t
	 * @throws PersistanceFailureSystemException
	 */
	void delete(T t) throws PersistanceFailureSystemException;

	/**
	 * 
	 * @param type
	 * @param id
	 * @throws PersistanceFailureSystemException
	 * @throws RecordNotFoundException
	 */
	void delete(Class<T> type, Object id)
			throws PersistanceFailureSystemException, RecordNotFoundException;

	/**
	 * 
	 * @param entities
	 * @return
	 * @throws PersistanceFailureSystemException
	 * @throws RecordAlreadyExistsException
	 */
	List<T> bulkCreate(List<T> entities)
			throws PersistanceFailureSystemException,
			RecordAlreadyExistsException;

	/**
	 * 
	 * @param entities
	 * @return
	 * @throws PersistanceFailureSystemException
	 */
	List<T> bulkUdate(List<T> entities)
			throws PersistanceFailureSystemException;

	/**
	 * 
	 * @param type
	 * @param id
	 * @return
	 * @throws RetrievalFailureSystemException
	 * @throws RecordNotFoundException
	 */
	T find(Class<T> type, Object id) throws RetrievalFailureSystemException,
			RecordNotFoundException;

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
	 * 
	 * @param type
	 * @return
	 * @throws RetrievalFailureSystemException
	 */
	List<T> findAll(Class<T> type) throws RetrievalFailureSystemException;
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

}
