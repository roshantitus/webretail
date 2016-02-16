/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public interface BaseDao<T> {

	T create(T t);
	T update(T t);
	void delete(T t);
	void delete(Class<T> type, Object id);
	T find(Class<T> type, Object id);
	List<T> findWithNamedQuery(String queryName);
	List<T> findWithNamedQuery(String queryName, Map<String, Object> params);
	List<T> findAll(Class<T> type);
}
