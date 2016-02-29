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

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.model.Product;
import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.data.entity.enums.OrderStatus;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class EStoreAdminServiceTest {
	

	@Inject
	private EStoreAdminService eStoreAdminService;	
	
	

	@Test
	public void testCategories()
	{
		try {
			Category newCategory = getNewCategory();
			
			//Add category
			Long categoryId = eStoreAdminService.addCategory(newCategory);
			
			//Get category by id
			Category categoryFromDB = eStoreAdminService.getCategory(categoryId);
			
			assertNotNull(categoryFromDB);
			assertNotNull(categoryFromDB.getCategoryId());
			assertEquals(categoryId, categoryFromDB.getCategoryId());
			assertNotNull(categoryFromDB.getCategoryName());
			assertEquals(newCategory.getCategoryName(), categoryFromDB.getCategoryName());
			assertNotNull(categoryFromDB.getCategoryDescription());
			assertEquals(newCategory.getCategoryDescription(), categoryFromDB.getCategoryDescription());
			
			//fetch all categories
			List<Category> categoryList = eStoreAdminService.getAllCategories();
			assertEquals(categoryList.size(), 1);
			
			//Update category
			Category categoryToUpdate = getCategoryWithChanges();
			categoryToUpdate.setCategoryId(categoryId);
			assertTrue(eStoreAdminService.updateCategory(categoryToUpdate));
			
			Category updatedCategoryFromDB = eStoreAdminService.getCategory(categoryId);
			
			assertNotNull(updatedCategoryFromDB);
			assertNotNull(updatedCategoryFromDB.getCategoryName());
			assertEquals(updatedCategoryFromDB.getCategoryName(), categoryToUpdate.getCategoryName());
			assertNotNull(updatedCategoryFromDB.getCategoryDescription());
			assertEquals(updatedCategoryFromDB.getCategoryDescription(), categoryToUpdate.getCategoryDescription());		
			
			//delete Category
			assertTrue(eStoreAdminService.deleteCategory(categoryId));
			
			
			try {
				eStoreAdminService.getCategory(categoryId);
				fail("Category should have been deleted");
			} catch (RecordNotFoundException e) {
				
			}
			
			//fetch all categories
			assertTrue(eStoreAdminService.getAllCategories().size() == 0);			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}	
	
	private Category getNewCategory() {
		Category category = new Category();
		category.setCategoryName("Books");
		category.setCategoryDescription("Collection of classic and non-classic books");
		return category;
	}	
	
	private Category getCategoryWithChanges() {
		Category category = new Category();
		category.setCategoryName("Science Fiction Books");
		category.setCategoryDescription("Collection of sci-fi books");
		return category;
	}		
	
	@Test
	public void testProducts()
	{
		try {
			Product newProduct = getNewProduct();
			
			//Add product
			Long productId = eStoreAdminService.addProduct(newProduct);
			
			//Get product by id
			Product productFromDB = eStoreAdminService.getProduct(productId);
			
			assertNotNull(productFromDB);
			assertNotNull(productFromDB.getProductId());
			assertEquals(productId, productFromDB.getProductId());
			assertNotNull(productFromDB.getProductName());
			assertEquals(newProduct.getProductName(), productFromDB.getProductName());
			assertNotNull(productFromDB.getProductDescription());
			assertEquals(newProduct.getProductDescription(), productFromDB.getProductDescription());
			
			//fetch all categories
			List<Product> productList = eStoreAdminService.getAllProducts();
			assertEquals(productList.size(), 1);
			
			//Update product
			Product productToUpdate = getProductWithChanges();
			productToUpdate.setProductId(productId);
			assertTrue(eStoreAdminService.updateProduct(productToUpdate));
			
			Product updatedProductFromDB = eStoreAdminService.getProduct(productId);
			
			assertNotNull(updatedProductFromDB);
			assertNotNull(updatedProductFromDB.getProductName());
			assertEquals(updatedProductFromDB.getProductName(), productToUpdate.getProductName());
			assertNotNull(updatedProductFromDB.getProductDescription());
			assertEquals(updatedProductFromDB.getProductDescription(), productToUpdate.getProductDescription());		
			
			//delete Product
			assertTrue(eStoreAdminService.deleteProduct(productId));
			
			
			try {
				eStoreAdminService.getProduct(productId);
				fail("Product should have been deleted");
			} catch (RecordNotFoundException e) {
				
			}
			
			//fetch all categories
			assertTrue(eStoreAdminService.getAllProducts().size() == 0);			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}		
	
	private Product getNewProduct() {
		Product product = new Product();
		product.setProductName("Mojo");
		product.setProductDescription("About finding yor mojo");
		product.setQuantity(20);
		product.setUnitPrice(395.75);
		return product;
	}	
	
	private Product getProductWithChanges() {
		Product product = new Product();
		product.setProductName("SCEA study guide");
		product.setProductDescription("SCEA certification study guide");
		product.setQuantity(50);
		product.setUnitPrice(500.00);		
		return product;
	}	
	
	@Test
	public void testOrders()
	{
		try {
			Order newOrder = getNewOrder();
			
			//Add order
			Long orderId = eStoreAdminService.addOrder(newOrder);
			
			//Get order by id
			Order orderFromDB = eStoreAdminService.getOrder(orderId);
			
			assertNotNull(orderFromDB);
			assertNotNull(orderFromDB.getOrderId());
			assertEquals(orderId, orderFromDB.getOrderId());
			assertNotNull(orderFromDB.getOrderStatus());
			assertEquals(newOrder.getOrderStatus(), orderFromDB.getOrderStatus());
			assertNotNull(orderFromDB.getOrderDate());
			assertEquals(newOrder.getOrderDate(), orderFromDB.getOrderDate());
			
			//fetch all categories
			List<Order> orderList = eStoreAdminService.getAllOrders();
			assertEquals(orderList.size(), 1);
			
			//Update order
			Order orderToUpdate = getOrderWithChanges();
			orderToUpdate.setOrderId(orderId);
			assertTrue(eStoreAdminService.updateOrder(orderToUpdate));
			
			Order updatedOrderFromDB = eStoreAdminService.getOrder(orderId);
			
			assertNotNull(updatedOrderFromDB);
			assertNotNull(updatedOrderFromDB.getOrderStatus());
			assertEquals(updatedOrderFromDB.getOrderStatus(), orderToUpdate.getOrderStatus());
			assertNotNull(updatedOrderFromDB.getOrderDate());
			assertEquals(updatedOrderFromDB.getOrderDate(), orderToUpdate.getOrderDate());		
			
			//delete Order
			assertTrue(eStoreAdminService.deleteOrder(orderId));
			
			
			try {
				eStoreAdminService.getOrder(orderId);
				fail("Order should have been deleted");
			} catch (RecordNotFoundException e) {
				
			}
			
			//fetch all categories
			assertTrue(eStoreAdminService.getAllOrders().size() == 0);			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}		
	
	private Order getNewOrder() {
		Order order = new Order();
		order.setOrderDate(Calendar.getInstance());
		order.setOrderStatus(OrderStatus.NEW.toString());
		return order;
	}	
	
	private Order getOrderWithChanges() {
		Order order = new Order();
		order.setOrderDate(Calendar.getInstance());
		order.setOrderStatus(OrderStatus.PROCESSING.toString());
		return order;
	}		
		
}
