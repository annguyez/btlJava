package com.gr21.dao;
import java.util.List;
import com.gr21.model.ProductDTO;
import com.gr21.model.Product_detailDTO;
public interface StatisticsDAO {
	//Đếm số bản ghi
	public long countTotalProduct(int category_id);
	public long countTotalProductShipped(int category_id);
	public long countTotalProductByMonth(String Month,int category_id);
	public long countTotalProductShippedByMonth(String Month,int category_id);
	
	//Lấy giá trị bản ghi
	public List<ProductDTO> getProducts(int category_id,String orderby,int startPosition,int maxResult);
	public List<ProductDTO> getProductsShipped(int category_id ,String orderby,int startPosition,int maxResult);
	public List<ProductDTO> getProductsByMonth(String Month,int category_id,String orderby, int startPosition, int maxResult);
	public List<ProductDTO> getProductsShippedByMonth(String Month,int category_id,String orderby, int startPosition, int maxResult);
	
	public ProductDTO getSingleProduct(int product_id,String month,int status);
	public Product_detailDTO getSingleProductDetail (String product_detail_id,String month,int status);
	public long[] getStatisticsleCategory(int category_id,String month,int status);
}
