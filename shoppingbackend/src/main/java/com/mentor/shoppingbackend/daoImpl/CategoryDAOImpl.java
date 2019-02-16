package com.mentor.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mentor.shoppingbackend.dao.CategoryDAO;
import com.mentor.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * Category category = new Category();
	 * 
	 * category = new Category();
	 * 
	 * category.setId(1); category.setName("Television on one");
	 * category.setImageURL("cat.png");
	 * category.setDescription("Description of television");
	 * 
	 * categories.add(category);
	 * 
	 * category = new Category();
	 * 
	 * category.setId(2); category.setName("Mobile");
	 * category.setImageURL("cat.png");
	 * category.setDescription("Description of Mobile");
	 * 
	 * categories.add(category);
	 * 
	 * category = new Category();
	 * 
	 * category.setId(3); category.setName("laptop");
	 * category.setImageURL("cat.png");
	 * category.setDescription("Description of laptop");
	 * 
	 * categories.add(category); }
	 */

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	// geting single category-----------

	@Override
	public Category get(int id) {

		/*
		 * for(Category category : categories) { if ((category.getId()) == id) return
		 * category; }
		 */

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {

		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	//Updating a single record-----------
	
	@Override
	public boolean update(Category category) {

		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
