/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.model;


/**
 * @author Roshan Titus
 *
 */
public class Category {
	
	private Long categoryId;
	private String categoryName;
	private String categoryDescription;
	
	
	
	public Category() {
		super();
		// TODO initialize object
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}		

}
