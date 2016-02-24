/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.model;

/**
 * @author Roshan Titus
 *
 */
public class Product {

	private Long productId;
	private String productName;
	private String productDescription;
	private Integer quantity;
	private Double unitPrice;
	
	
	public Product() {
		super();
		// TODO initialize object
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
