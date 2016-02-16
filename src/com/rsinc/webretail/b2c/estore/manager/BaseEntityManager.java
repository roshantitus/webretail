/**
 * 
 */
package com.rsinc.webretail.b2c.estore.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.entity.BaseBean;
import com.rsinc.webretail.b2c.estore.exception.BeanValidationException;

/**
 * @author Roshan Titus
 *
 */
@Component
public interface BaseEntityManager <T extends BaseBean> {

	BaseDao<T> getDao();
	
	T create(T t);
	T update(T t);
	void delete(T t);
	void deleteById(Object id);	
	void deleteById(Class<T> type, Object id);
	
	void setDefaultValues(T t);

	void validateForCreate(T t) throws BeanValidationException;
	void validateForUpdate(T t) throws BeanValidationException;
	void validateForDelete(T t) throws BeanValidationException;
	
	T load(Class<T> type, Object id);
	
	List<T> findAll();
	
	T loadById(Object id);
}
