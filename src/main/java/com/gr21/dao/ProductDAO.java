package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Color;
import com.gr21.entity.Product;
import com.gr21.entity.Size;

public interface ProductDAO {
	public Product getProduct(int product_id);
	public List<Product> getListProduct();
	public List<Product> getListNewest(int category_id,int startPosition,int maxResult);
	public String getProductName(int product_id);
	public List<String> getListCategoryName();
	public boolean create(Product product );
	public void delete(int product_id);
	public boolean update(Product product);
	public Product getProductDetailById(int product_id);
	public int getLastest ();
	public int getMaxDiscount(int product_id,String date);
	public List<Object[]> getProducts(int sale_id);
	public List<Product> getListProduct(int startPosition,int maxResult);
	public List<Product> getListProduct(int category_id,int startPosition,int maxResult);
	public Long getCountProduct();
	public Long getCountProduct(int category_id);
	public List<Product> getTopProduct(int startPosittion, int maxResult);
	public List<Product> getProductASC(int id);
	public List<Product> getProductByLikeName(String name);
	public  List<Product> getBestSeller(int category_id,int startPosition,int maxResult);
	List<Product> multiSearch(int category_id,int minPrice,int maxPrice,String name,int orderby,int startPosition,int maxResult);
	public  int counMultiSearch(int category_id,int minPrice,int maxPrice,String name,int orderby);
}
