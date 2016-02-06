/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Roshan Titus 
 *
 */
@MappedSuperclass
public abstract class BaseBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -302972352018750735L;
	
	//The ID field in MappedSuperclass. 
	//Getters and Setters and mapping for this field will be created only in the subclasses.
	protected Long id;
	protected Long createdBy;
	protected Date createdDate;
	protected Long updatedBy;
	protected Date updatedDate;
	protected Integer recordVersionNo;
	protected Boolean deletedYN;
	
	public BaseBean() {
		super();
	}

	@Column(name = "created_by")	
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "created_date")	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_by")	
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "updated_date")	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "record_version_no")	
	public Integer getRecordVersionNo() {
		return recordVersionNo;
	}
	public void setRecordVersionNo(Integer recordVersionNo) {
		this.recordVersionNo = recordVersionNo;
	}
	
	@Column(name = "deleted_yn")	
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseBean [id=" + id + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", recordVersionNo=" + recordVersionNo + ", deletedYN="
				+ deletedYN + "]";
	}
}
