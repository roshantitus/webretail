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

	public <T> List <T> queryForList(String query, Class T) throws RetrievalFailureSystemException{
		return getJdbcTemplate().query(query, new BeanPropertyRowMapper(T));
	}
	 
	public <T> List <T> queryForList(String query, Object[] args, Class t) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForList(query, args, t);
	}
	 
	public <T> List <T> queryForList(String query, RowMapper<T> mapper) throws RetrievalFailureSystemException{
		return getJdbcTemplate().query(query,mapper);
	}
	 
	public <T> List <T> queryForList(String query, Object[] args, RowMapper<T> mapper) throws RetrievalFailureSystemException{
	 	return getJdbcTemplate().query(query, args,mapper);
	}
	 
	public <T> List <T> queryForBeanList(String query, Object[] args, Class T) throws RetrievalFailureSystemException{
		return getJdbcTemplate().query(query, new BeanPropertyRowMapper(T));
	}
	 
	public <T> T queryForBean(String query, Object[] args,  Class T) throws RetrievalFailureSystemException{
		return (T) getJdbcTemplate().queryForObject(query, args, new BeanPropertyRowMapper(T));
	}
	 
	public <T> T queryForObject(String query, Object[] args, Class t) throws RetrievalFailureSystemException{
		return (T) getJdbcTemplate().queryForObject(query, args, t);
	}
	 
	public <T> T queryForObject(String query, RowMapper<T> mapper) throws RetrievalFailureSystemException{
		return getJdbcTemplate().queryForObject(query, mapper);
	}
	 
	public <T> T queryForObject(String query, Object[] args,  RowMapper<T> mapper) throws RetrievalFailureSystemException{
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
