/**
 * 
 */
package com.rs.webretail.b2c.estore.domain;

import java.util.Date;

/**
 * @author Roshan Titus
 *
 */
public class BaseBean {
	
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private Integer recordVersionNo;
	private Boolean deletedYN;
	
	public BaseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getRecordVersionNo() {
		return recordVersionNo;
	}
	public void setRecordVersionNo(int recordVersionNo) {
		this.recordVersionNo = recordVersionNo;
	}
	public Boolean getDeletedYN() {
		return deletedYN;
	}
	public void setDeletedYN(Boolean deletedYN) {
		this.deletedYN = deletedYN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((deletedYN == null) ? 0 : deletedYN.hashCode());
		result = prime * result + recordVersionNo;
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBean other = (BaseBean) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (deletedYN == null) {
			if (other.deletedYN != null)
				return false;
		} else if (!deletedYN.equals(other.deletedYN))
			return false;
		if (recordVersionNo != other.recordVersionNo)
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BaseBean [createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", recordVersionNo=" + recordVersionNo + ", deletedYN=" + deletedYN
				+ "]";
	}
	
	

}
