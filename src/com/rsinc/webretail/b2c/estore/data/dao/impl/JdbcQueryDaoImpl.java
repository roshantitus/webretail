/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.data.dao.QueryDao;

/**
 * @author Roshan Titus
 *
 */
@Repository
public class JdbcQueryDaoImpl extends JdbcDaoSupport implements QueryDao {
	
	@Inject
	private DataSource dataSource;	
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}	

	public <E> List <E> queryForList(String query, Class<E> clazz) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForList(query, null, clazz);
	}
	 
	public <E> List <E> queryForList(String query, Object[] args, Class<E> clazz) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForList(query, args, clazz);
	}
	 
	public <E> List <E> queryForList(String query, RowMapper<E> mapper) throws RetrievalFailureSystemException{
		return getJdbcTemplate().query(query, mapper);
	}
	 
	public <E> List <E> queryForList(String query, Object[] args, RowMapper<E> mapper) throws RetrievalFailureSystemException{
	 	return getJdbcTemplate().query(query, args, mapper);
	}
	 
	public <E> List <E> queryForBeanList(String query, Object[] args, Class<E> clazz) throws RetrievalFailureSystemException{
		return getJdbcTemplate().query(query, args, new BeanPropertyRowMapper<E>(clazz));
	}
	 
	public <E> E queryForBean(String query, Object[] args,  Class<E> clazz) throws RetrievalFailureSystemException{
		return (E) getJdbcTemplate().queryForObject(query, args, new BeanPropertyRowMapper<E>(clazz));
	}
	 
	public <E> E queryForObject(String query, Object[] args, Class<E> clazz) throws RetrievalFailureSystemException{
		return (E) getJdbcTemplate().queryForObject(query, args, clazz);
	}
	 
	public <E> E queryForObject(String query, RowMapper<E> mapper) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForObject(query, mapper);
	}
	 
	public <E> E queryForObject(String query, Object[] args,  RowMapper<E> mapper) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForObject(query, args, mapper);
	}
	 
	public Map<String, Object> queryForMap(String query, Object[] args) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForMap(query, args);
	}
	 
	public List< Map<String, Object>> queryForList(String query) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForList(query);
	}
	 
	public List<Map<String, Object>> queryForList(String query, Object[] args) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForList(query, args);	
	}
}
