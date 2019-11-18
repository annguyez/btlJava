package com.gr21.services.imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.ProductDAO;
import com.gr21.dao.Product_detailDAO;
import com.gr21.dao.imp.ProductImp;
import com.gr21.entity.Product;
import com.gr21.entity.Product_detail;
import com.gr21.model.ProductDTO;
import com.gr21.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product_detailDAO product_detailDAO;

	public List<Product> getListProduct() {
		// TODO Auto-generated method stub
		return productDAO.getListProduct();
	}

	public List<ProductDTO> getListNewest(int category_id,int startPosition,int maxResult) {
		// TODO Auto-generated method stub
		List<Product> list= productDAO.getListNewest(category_id,startPosition, maxResult);
		List<ProductDTO> result = this.toDTO(list);
		return result;		
	}

	public Product getProductDetailById(int product_id) {
		// TODO Auto-generated method stub
		return productDAO.getProductDetailById(product_id);
	}

	public void delete(int product_id) {
		// TODO Auto-generated method stub
		productDAO.delete(product_id);

	}

	public boolean create(Product product) {
		// TODO Auto-generated method stub
		Set<Product_detail> detail = product.getProducts_detail();
		Set<Product_detail> detail2 = new HashSet<Product_detail>();
		List<Product_detail> list = new ArrayList(detail);
		int color,size;
		Product_detail d2;
		if(!list.isEmpty()) {
			
			for(int i=0;i<list.size();i++) {
				Product_detail d1 = new Product_detail();
				d1 = (Product_detail) list.get(i);
				color=d1.getColor().getColor_id();
				size=d1.getSize().getSize_id();
				for(int j=i+1;j<list.size();j++) {
					d2 = (Product_detail) list.get(j);
					if(color==d2.getColor().getColor_id()&&size==d2.getSize().getSize_id()) {
						d1.setQuantity(d1.getQuantity()+d2.getQuantity());
				
						list.remove(j);
						j--;
					}
				}
				detail2.add(d1);
			}
		}
		product.setProducts_detail(detail2);
		boolean flag =productDAO.create(product);
		return flag;
	
	}

	public int getLastest() {
		// TODO Auto-generated method stub
		return productDAO.getLastest();
	}

	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(product_id);
	}

	public boolean update(Product product) {
		
		Product oldProduct = productDAO.getProduct(product.getProduct_id());
		Set<Product_detail> detail = product.getProducts_detail();
		Set<Product_detail> detail2 = new HashSet<Product_detail>();
		List<Product_detail> list = new ArrayList(detail);
		int color,size;
		Product_detail d2;
		if(!list.isEmpty()) {
			
			for(int i=0;i<list.size();i++) {
				Product_detail d1 = new Product_detail();
				d1 = (Product_detail) list.get(i);
				color=d1.getColor().getColor_id();
				size=d1.getSize().getSize_id();
				for(int j=i+1;j<list.size();j++) {
					d2 = (Product_detail) list.get(j);
					if(color==d2.getColor().getColor_id()&&size==d2.getSize().getSize_id()) {
						d1.setQuantity(d1.getQuantity()+d2.getQuantity());
				
						list.remove(j);
						j--;
					}
				}
				detail2.add(d1);
			}
		}
			
		Product old = this.getProduct(product.getProduct_id());
		int quantity = 0;
		Product_detail oldDetail = new Product_detail();
		for(Product_detail pr_detail:detail2) {
			System.out.println(pr_detail.getProduct_detail_id());
			quantity = pr_detail.getQuantity();
			try {
				oldDetail = product_detailDAO.getProduct_detailByOr(pr_detail.getProduct_detail_id());
				pr_detail.setProduct(oldDetail.getProduct());
				pr_detail.setOrders_detail(oldDetail.getOrders_detail());;
				pr_detail.setQuantity(quantity);
			} catch (Exception e) {
				pr_detail.setProduct(oldProduct);
			}
			
		}
		product.setSales(old.getSales());
		product.setProducts_detail(detail2);
	 return productDAO.update(product);

//		return true;
	}

	public int getMaxDiscount(int product_id, String date) {
		// TODO Auto-generated method stub
		return productDAO.getMaxDiscount(product_id, date);
	}

	public List<Object[]> getProducts(int sale_id) {
		// TODO Auto-generated method stub
		return productDAO.getProducts(sale_id);
	}

	public List<Product> getListProduct(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		return productDAO.getListProduct(startPosition, maxResult);
	}

	public List<Product> getListProduct(int category_id, int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		return productDAO.getListProduct(category_id, startPosition, maxResult);
	}

	public Long getCountProduct() {
		// TODO Auto-generated method stub
		return productDAO.getCountProduct();
	}

	public Long getCountProduct(int category_id) {
		// TODO Auto-generated method stub
		return productDAO.getCountProduct(category_id);
	}
	
	public List<ProductDTO> getProductASC(int id) {
		// TODO Auto-generated method stub
		List<Product>  list =productDAO.getProductASC(id);
		List<ProductDTO> result = this.toDTO(list);
		return result;
	}

	public List<ProductDTO> getProductByLikeName(String name) {
		// TODO Auto-generated method stub
		List<Product>  list =productDAO.getProductByLikeName(name);
		List<ProductDTO> result = this.toDTO(list);
		return result;
	}

	
	public List<ProductDTO> getBestSeller(int category_id,int startPosition,int maxResult) {
		// TODO Auto-generated method stub
//		 List<Product> list= productDAO.getListNewest(startPosition, maxResult);
		 List<Product> list= productDAO.getBestSeller(category_id, startPosition, maxResult);
		List<ProductDTO> result = this.toDTO(list);
		return result;		
	}
	
	public List<ProductDTO> multiSearch(int category_id,int minPrice,int maxPrice,String name,int oderby,int startPosition,int maxResult){
		 List<Product> list= productDAO.multiSearch(category_id, minPrice, maxPrice, name, oderby, startPosition, maxResult);
			List<ProductDTO> result = this.toDTO(list);
			return result;	
	}
	
	
	public  int countMultiSearch(int category_id,int minPrice,int maxPrice,String name,int orderby) {
		int count = 0;
//		count = productDAO.counMultiSearch(category_id, minPrice, maxPrice, name, oderby);
		try {
			count = productDAO.counMultiSearch(category_id, minPrice, maxPrice, name, orderby);
		}
		catch (Exception e) {
			count =0;
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<ProductDTO> toDTO(List<Product> list){
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(today);
		int discount=0;
	
		for(Product pro:list) {
			System.out.println(pro.getProduct_id()+"   "+pro.getProduct_name());
			ProductDTO proDTO = new ProductDTO();
			proDTO.setProduct_name(pro.getProduct_name());
			proDTO.setProduct_id(pro.getProduct_id());
			proDTO.setImage(pro.getImage());
			proDTO.setPrice(pro.getPrice());
			try {
				discount=productDAO.getMaxDiscount(proDTO.getProduct_id(), date);
			}
			catch (Exception e) {
				discount=0;
			}
			proDTO.setDiscount(discount);
			result.add(proDTO);
		}
		return result;
	}	
	
}
