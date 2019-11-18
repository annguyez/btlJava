package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Category;
import com.gr21.entity.Product;

public interface CategoryDAO {
	public Category getCategory(int category_id);
	public List<Category> getListCategory();
	public String getCategoryName(int category_id);
	public List<String> getListCategoryName();
	public void create(Category category );
	public void delete(int category_id);
	public void update(Category category);
	public List<Product> searchProductByCategory(int id);
	public boolean check(String category_name);
}
