/**
 * 
 */
package com.rs.webretail.b2c.estore.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Roshan Titus
 *
 */
public interface BaseDao<T> {

	public T create(T t);
	public T update(T t);
	public void delete(Class<T> type, Object id);
	public T find(Class<T> type, Object id);
	public List<T> findWithNamedQuery(String queryName);
	public List<T> findWithNamedQuery(String queryName, Map<String, Object> params);
}
