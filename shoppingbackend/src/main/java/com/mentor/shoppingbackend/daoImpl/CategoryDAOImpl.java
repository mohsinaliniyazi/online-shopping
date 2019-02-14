package com.mentor.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mentor.shoppingbackend.dao.CategoryDAO;
import com.mentor.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		category.setId(1);
		category.setName("Television on one");
		category.setImageURL("cat.png");
		category.setDescription("Description of television");

		categories.add(category);

		category = new Category();

		category.setId(2);
		category.setName("Mobile");
		category.setImageURL("cat.png");
		category.setDescription("Description of Mobile");

		categories.add(category);
		
		category = new Category();

		category.setId(3);
		category.setName("laptop");
		category.setImageURL("cat.png");
		category.setDescription("Description of laptop");

		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category : categories) {
			if ((category.getId()) == id) return category;
		} 
		return null;
	}

}
