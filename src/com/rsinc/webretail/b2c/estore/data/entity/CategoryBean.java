/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Roshan Titus
 *
 */
@Entity
@Access(AccessType.PROPERTY)
//@NamedQueries({@NamedQuery(name="findByUsername", query=""), })
@Table(name="CATEGORY")
public class CategoryBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 585130359548242794L;
	
	private String categoryName;
	private String categoryDescription;

	public CategoryBean() {
		super();
		// TODO initialize object
	}

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "category_id")
	public Long getCategoryId() {
		return id;
	}
	

	public void setCategoryId(Long id) {
		this.id = id;
	}	

	@Column(name = "category_name")	
	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "category_description")	
	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}	
	
	
}
