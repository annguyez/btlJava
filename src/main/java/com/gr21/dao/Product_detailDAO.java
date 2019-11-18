package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Color;
import com.gr21.entity.Product_detail;
import com.gr21.entity.Size;
import com.gr21.model.SizeDTO;

public interface Product_detailDAO {
	public Product_detail getProduct_detail(String product_detail_id);
	public List<Product_detail> getListProduct_detail();
	public String getProduct_detailName(String product_detail_id);
	public List<String> getListProduct_detailName();
	public void create(Product_detail product_detail );
	public void delete(String product_detail_id);
	public void update(Product_detail product_detail);
	public List<Color> getColor(int product_id);
	public List<Size> getSizeByColor(int color_id, int product_id);
	public List<SizeDTO> getListSize(int product_id,int color_id);
	public List<Product_detail> getProduct_detailsByProduct_id(int product_id);
	public Product_detail getProduct_detailByOr(String product_detail_id);
	public List <Product_detail> getListProduct_detailByOr(String product_detail_id);
}
