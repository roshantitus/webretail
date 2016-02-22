/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager;

import java.util.List;

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

	PersistanceDao<T> getPersistanceDao();
	QueryDao getQueryDao();
	
	T create(T t) throws PersistanceFailureSystemException, RecordAlreadyExistsException, ValidationException;
	T update(T t) throws PersistanceFailureSystemException, ValidationException;
	void delete(T t) throws PersistanceFailureSystemException, ValidationException;
	void deleteById(Object id) throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException;	
	void deleteById(Class<T> type, Object id) throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException;	
	List<T> bulkCreate(List<T> entities) throws PersistanceFailureSystemException, RecordAlreadyExistsException, ValidationException;
	List<T> bulkUdate(List<T> entities) throws PersistanceFailureSystemException, ValidationException;		
	void setDefaultValues(T t);

	void validateForCreate(T t) throws ValidationException;
	void validateForUpdate(T t) throws ValidationException;
	void validateForDelete(T t) throws ValidationException;
	
	T load(Class<T> type, Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException;	
	List<T> findAll() throws RetrievalFailureSystemException;	
	T loadById(Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException;

}
