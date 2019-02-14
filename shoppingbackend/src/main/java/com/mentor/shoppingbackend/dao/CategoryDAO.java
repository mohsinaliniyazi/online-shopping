package com.mentor.shoppingbackend.dao;

import java.util.List;

import com.mentor.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
	
	
}