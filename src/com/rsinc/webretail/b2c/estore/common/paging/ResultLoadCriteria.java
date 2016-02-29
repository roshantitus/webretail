/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.paging;

import java.util.Map;

/**
 * @author Roshan Titus
 *
 */
public class ResultLoadCriteria {
	
	private Integer first; 
	private Integer pageSize;
	private Map<String, SortOrder> orderBy;
	private Map<String, Object> filters;
	
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, SortOrder> getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Map<String, SortOrder> orderBy) {
		this.orderBy = orderBy;
	}
	public Map<String, Object> getFilters() {
		return filters;
	}
	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}

	
}
