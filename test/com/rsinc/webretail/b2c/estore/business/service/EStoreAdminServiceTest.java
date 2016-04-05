/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.business.domain.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.enums.OrderStatus;
import com.rsinc.webretail.b2c.estore.common.config.AdminAppConfig;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AdminAppConfig.class})
public class EStoreAdminServiceTest {
	

	@Inject
	private EStoreAdminService eStoreAdminService;	
	
	

	@Test
	public void testCategories()
	{
		try {
			CategoryBean newCategory = getNewCategory();
			
			//Add category
			Long categoryId = eStoreAdminService.addCategory(newCategory);
			
			//Get category by id
			CategoryBean categoryFromDB = eStoreAdminService.getCategory(categoryId);
			
			assertNotNull(categoryFromDB);
			assertNotNull(categoryFromDB.getCategoryId());
			assertEquals(categoryId, categoryFromDB.getCategoryId());
			assertNotNull(categoryFromDB.getCategoryName());
			assertEquals(newCategory.getCategoryName(), categoryFromDB.getCategoryName());
			assertNotNull(categoryFromDB.getCategoryDescription());
			assertEquals(newCategory.getCategoryDescription(), categoryFromDB.getCategoryDescription());
			
			//fetch all categories
			List<CategoryBean> categoryList = eStoreAdminService.getAllCategories();
			assertEquals(categoryList.size(), 1);
			
			//Update category
			CategoryBean categoryToUpdate = getCategoryWithChanges();
			categoryToUpdate.setCategoryId(categoryId);
			assertTrue(eStoreAdminService.updateCategory(categoryToUpdate));
			
			CategoryBean updatedCategoryFromDB = eStoreAdminService.getCategory(categoryId);
			
			assertNotNull(updatedCategoryFromDB);
			assertNotNull(updatedCategoryFromDB.getCategoryName());
			assertEquals(updatedCategoryFromDB.getCategoryName(), categoryToUpdate.getCategoryName());
			assertNotNull(updatedCategoryFromDB.getCategoryDescription());
			assertEquals(updatedCategoryFromDB.getCategoryDescription(), categoryToUpdate.getCategoryDescription());		
			
			//delete CategoryBean
			assertTrue(eStoreAdminService.deleteCategory(categoryId));
			
			
			try {
				eStoreAdminService.getCategory(categoryId);
				fail("CategoryBean should have been deleted");
			} catch (RecordNotFoundException e) {
				
			}
			
			//fetch all categories
			assertTrue(eStoreAdminService.getAllCategories().size() == 0);			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}	
	
	private CategoryBean getNewCategory() {
		CategoryBean category = new CategoryBean();
		category.setCategoryName("Books");
		category.setCategoryDescription("Collection of classic and non-classic books");
		return category;
	}	
	
	private CategoryBean getCategoryWithChanges() {
		CategoryBean category = new CategoryBean();
		category.setCategoryName("Science Fiction Books");
		category.setCategoryDescription("Collection of sci-fi books");
		return category;
	}		
	
	@Test
	public void testProducts()
	{
		try {			
			
			ProductBean newProduct = getNewProduct(eStoreAdminService.addCategory(getNewCategory()));
			
			//Add product
			Long productId = eStoreAdminService.addProduct(newProduct);
			
			//Get product by id
			ProductBean productFromDB = eStoreAdminService.getProduct(productId);
			
			assertNotNull(productFromDB);
			assertNotNull(productFromDB.getProductId());
			assertEquals(productId, productFromDB.getProductId());
			assertNotNull(productFromDB.getProductName());
			assertEquals(newProduct.getProductName(), productFromDB.getProductName());
			assertNotNull(productFromDB.getProductDescription());
			assertEquals(newProduct.getProductDescription(), productFromDB.getProductDescription());
			
			//fetch all categories
			List<ProductBean> productList = eStoreAdminService.getAllProducts();
			assertEquals(productList.size(), 1);
			
			//Update product
			
			ProductBean productToUpdate = getProductWithChanges(eStoreAdminService.addCategory(getCategoryWithChanges()));
			productToUpdate.setProductId(productId);
			assertTrue(eStoreAdminService.updateProduct(productToUpdate));
			
			ProductBean updatedProductFromDB = eStoreAdminService.getProduct(productId);
			
			assertNotNull(updatedProductFromDB);
			assertNotNull(updatedProductFromDB.getProductName());
			assertEquals(updatedProductFromDB.getProductName(), productToUpdate.getProductName());
			assertNotNull(updatedProductFromDB.getProductDescription());
			assertEquals(updatedProductFromDB.getProductDescription(), productToUpdate.getProductDescription());		
			
			//delete ProductBean
			assertTrue(eStoreAdminService.deleteProduct(productId));
			
			
			try {
				eStoreAdminService.getProduct(productId);
				fail("ProductBean should have been deleted");
			} catch (RecordNotFoundException e) {
				
			}
			
			//fetch all categories
			assertTrue(eStoreAdminService.getAllProducts().size() == 0);			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}		
	
	private ProductBean getNewProduct(Long categoryId) {
		ProductBean product = new ProductBean();
		product.setProductName("Mojo");
		product.setProductDescription("About finding yor mojo");
		product.setQuantity(20);
		product.setUnitPrice(395.75);
		
		CategoryBean category = new CategoryBean();
		category.setCategoryId(categoryId);
		product.setCategory(category);
		return product;
	}	
	
	private ProductBean getProductWithChanges(Long categoryId) {
		ProductBean product = new ProductBean();
		product.setProductName("SCEA study guide");
		product.setProductDescription("SCEA certification study guide");
		product.setQuantity(50);
		product.setUnitPrice(500.00);	
		
		CategoryBean category = new CategoryBean();
		category.setCategoryId(categoryId);
		product.setCategory(category);		
		return product;
	}	
	
	@Test
	public void testOrders()
	{
		try {
			OrderBean newOrder = getNewOrder();
			
			//Add order
			Long orderId = eStoreAdminService.addOrder(newOrder);
			
			//Get order by id
			OrderBean orderFromDB = eStoreAdminService.getOrder(orderId);
			
			assertNotNull(orderFromDB);
			assertNotNull(orderFromDB.getOrderId());
			assertEquals(orderId, orderFromDB.getOrderId());
			assertNotNull(orderFromDB.getOrderStatus());
			assertEquals(newOrder.getOrderStatus(), orderFromDB.getOrderStatus());
			assertNotNull(orderFromDB.getOrderDate());
			assertTrue(orderFromDB.getOrderDate().equals(newOrder.getOrderDate()));
			
			//fetch all categories
			List<OrderBean> orderList = eStoreAdminService.getAllOrders();
			assertEquals(orderList.size(), 1);
			
			//Update order
			OrderBean orderToUpdate = getOrderWithChanges();
			orderToUpdate.setOrderId(orderId);
			assertTrue(eStoreAdminService.updateOrder(orderToUpdate));
			
			OrderBean updatedOrderFromDB = eStoreAdminService.getOrder(orderId);
			
			assertNotNull(updatedOrderFromDB);
			assertNotNull(updatedOrderFromDB.getOrderStatus());
			assertEquals(updatedOrderFromDB.getOrderStatus(), orderToUpdate.getOrderStatus());
			assertNotNull(updatedOrderFromDB.getOrderDate());
			assertEquals(updatedOrderFromDB.getOrderDate(), orderToUpdate.getOrderDate());		
			
			//delete OrderBean
			assertTrue(eStoreAdminService.deleteOrder(orderId));
			
			
			try {
				eStoreAdminService.getOrder(orderId);
				fail("OrderBean should have been deleted");
			} catch (RecordNotFoundException e) {
				
			}
			
			//fetch all categories
			assertTrue(eStoreAdminService.getAllOrders().size() == 0);			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}		
	
	private OrderBean getNewOrder() {
		OrderBean order = new OrderBean();
		order.setOrderDate(Calendar.getInstance());
		order.setOrderStatus(OrderStatus.NEW);
		return order;
	}	
	
	private OrderBean getOrderWithChanges() {
		OrderBean order = new OrderBean();
		order.setOrderDate(Calendar.getInstance());
		order.setOrderStatus(OrderStatus.PROCESSING);
		return order;
	}		
		
}
