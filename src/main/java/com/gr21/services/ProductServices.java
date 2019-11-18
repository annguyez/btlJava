package com.gr21.services;

import java.util.List;

import com.gr21.entity.Product;
import com.gr21.model.ProductDTO;

public interface ProductServices {
	public List<Product> getListProduct();
	public List<ProductDTO> getListNewest(int category_id,int startPosition,int maxResult);
	public Product getProductDetailById(int product_id);
	public void delete(int product_id);
	public boolean create(Product product );
	public boolean update(Product product );
	public int getLastest();
	public Product getProduct(int product_id);
	public int getMaxDiscount(int product_id,String date);
	public List<Object[]> getProducts(int sale_id);
	public List<Product> getListProduct(int startPosition,int maxResult);
	public List<Product> getListProduct(int category_id,int startPosition,int maxResult);
	public Long getCountProduct();
	public Long getCountProduct(int category_id);
	public List<ProductDTO> getProductASC(int id);
	public List<ProductDTO> getProductByLikeName(String name);
	
	public List<ProductDTO> getBestSeller(int category_id,int startPosition,int maxResult);
	public List<ProductDTO> multiSearch(int category_id,int minPrice,int maxPrice,String name,int oderby,int startPosition,int maxResult);
	public  int countMultiSearch(int category_id,int minPrice,int maxPrice,String name,int orderby);
	
}
