/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.BeanValidationException;
import com.rsinc.webretail.b2c.estore.data.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.data.entity.BaseBean;

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
