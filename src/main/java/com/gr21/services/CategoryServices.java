package com.gr21.services;

import java.util.List;

import com.gr21.entity.Category;
import com.gr21.entity.Product;
import com.gr21.model.CategoryDTO;
import com.gr21.model.ProductDTO;

public interface CategoryServices {
	public List<Category> getListCategory();
	public List<ProductDTO> searchProductByCategory(int id);
	public Category getCategory(int category_id);
	
	public void delete(int category_id);
	public void create(Category category );
	public void update(Category category );
	public int getLastest();
	public boolean check(String category_name);
	
}
