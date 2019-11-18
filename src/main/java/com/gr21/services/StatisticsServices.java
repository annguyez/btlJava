package com.gr21.services;

import java.util.List;

import com.gr21.model.CategoryStatisticDTO;
import com.gr21.model.ProductDTO;
import com.gr21.model.Product_detailDTO;

public interface StatisticsServices {
	public long countTotalProduct(int category_id);
	public long countTotalProductShipped(int category_id);
	public long countTotalProductByMonth(String month,int category_id);
	public long countTotalProductShippedByMonth(String month,int category_id);
	
	

	public List<ProductDTO> getProducts(int category_id,int orderby,int startPosition,int maxResult);
	public List<ProductDTO> getProductsShipped(int category_id,int orderby,int startPosition,int maxResult);
	
	public List<ProductDTO> getProductsByMonth(String month,int category_id,int orderby, int startPosition, int maxResult);

	
	public List<ProductDTO> getProductsShippedByMonth(String month, int category_id,int orderby,int startPosition, int maxResult);
	
	public ProductDTO getSingleProduct(int product_id,String month,int status);
	public List<Product_detailDTO> getSingleProductDetails(int product_id,String month,int status);
	public List<CategoryStatisticDTO> getStatisticsleCategory(String month);

	
}
