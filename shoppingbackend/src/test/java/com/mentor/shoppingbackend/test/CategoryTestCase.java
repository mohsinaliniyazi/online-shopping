package com.mentor.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mentor.shoppingbackend.dao.CategoryDAO;
import com.mentor.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mentor.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Tele");
	 * category.setDescription("descrip"); category.setImageURL("1.png");
	 * 
	 * assertEquals("Successfull addded a category inside the table",true,
	 * categoryDAO.add(category));
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfull fetch a category inside the table", "Tele",
	 * category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfull update a category inside the table", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfull delete a category inside the table", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfull fetch all category inside the table",1,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCrudCategory() {

		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is description of laptop");
		category.setImageURL("1.png");

		assertEquals("Successfull addded a category inside the table", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is description of Television");
		category.setImageURL("2.png");

		assertEquals("Successfull addded a category inside the table", true, categoryDAO.add(category));

		
		// fetching and renaming category----
		
		category = categoryDAO.get(2);

		category.setName("New Laptop");

		assertEquals("Successfull update a category inside the table", true, categoryDAO.update(category));
		
		//delete the category-----------
		
		assertEquals("Successfull delete a category inside the table", true, categoryDAO.delete(category));
		
		//fetching the list ------------
		
		assertEquals("Successfull fetch all category inside the table",1, categoryDAO.list().size());
		
	}

}
