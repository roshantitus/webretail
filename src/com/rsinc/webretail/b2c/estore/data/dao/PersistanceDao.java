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

	T create(T t) throws PersistanceFailureSystemException, RecordAlreadyExistsException;
	T update(T t) throws PersistanceFailureSystemException;
	void delete(T t) throws PersistanceFailureSystemException;
	void delete(Class<T> type, Object id) throws PersistanceFailureSystemException, RecordNotFoundException;
	List<T> bulkCreate(List<T> entities) throws PersistanceFailureSystemException, RecordAlreadyExistsException;
	List<T> bulkUdate(List<T> entities) throws PersistanceFailureSystemException;	
	
	T find(Class<T> type, Object id) throws RetrievalFailureSystemException, RecordNotFoundException;
	List<T> findWithNamedQuery(String queryName) throws RetrievalFailureSystemException;
	List<T> findWithNamedQuery(String queryName, Map<String, Object> params) throws RetrievalFailureSystemException;
	List<T> findAll(Class<T> type) throws RetrievalFailureSystemException;

}
