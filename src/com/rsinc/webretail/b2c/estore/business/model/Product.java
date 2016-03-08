/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.model;

import javax.validation.constraints.Size;

/**
 * @author Roshan Titus
 *
 */
public class Product {

	private Long productId;
	
	@Size(min=2, max=30) 
	private String productName;
	
	@Size(min=2, max=300) 
	private String productDescription;
	
	
	private Integer quantity;
	private Double unitPrice;
	private Category category;
	
	
	public Product() {
		super();
		// TODO initialize object
	}
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
