package com.gr21.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gr21.entity.Category;
import com.gr21.entity.Product;
import com.gr21.model.CategoryStatisticDTO;
import com.gr21.model.ProductDTO;
import com.gr21.model.Product_detailDTO;
import com.gr21.services.CategoryServices;
import com.gr21.services.ProductServices;
import com.gr21.services.Product_detailsServices;
import com.gr21.services.StatisticsServices;

@Controller
@RequestMapping("/admin/statistics")
public class StatisticsController {
	
	
	public static final  int LIMIT=5;
	@Autowired
	ProductServices productServices;
	@Autowired
	Product_detailsServices product_detailsServices;
	@Autowired 
	StatisticsServices statisticsServices;
	@Autowired
	CategoryServices categoryServices;
	
	@PostMapping("/all")
	public String redirectAllbyMonth(@RequestParam(required = false) String month,@RequestParam int category_id,@RequestParam int orderby ) {	
		if(month=="") {
			return "redirect:/admin/statistics/all/"+category_id+"/"+orderby+"/1";
		}
		return "redirect:/admin/statistics/all/"+month+"/"+category_id+"/"+orderby+"/1";
	}
	
	@GetMapping("/all/{category_id}/{orderby}/{page}")
	public String getProductByMonth(@PathVariable int category_id,@PathVariable int orderby,@PathVariable int page,ModelMap modelMap) {	
		long total = statisticsServices.countTotalProduct( category_id);
		int startPosition = (page-1)*LIMIT;
		int maxResult =LIMIT;
		List<Category> categories = categoryServices.getListCategory();
		List<ProductDTO> products = statisticsServices.getProducts(category_id, orderby, startPosition, maxResult);
		
		
		modelMap.addAttribute("totalpage",(int)Math.ceil((double)total/LIMIT));
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("products",products);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("url", "/admin/statistics/all/"+category_id+"/"+orderby);
		return "statistics";
	}
	
	
	@GetMapping("/all/{month}/{category_id}/{orderby}/{page}")
	public String getProductByMonth(@PathVariable String month,@PathVariable int category_id,@PathVariable int orderby,@PathVariable int page,ModelMap modelMap) {	
		long total = statisticsServices.countTotalProductByMonth(month, category_id);
		int startPosition = (page-1)*LIMIT;
		int maxResult =LIMIT;
		List<Category> categories = categoryServices.getListCategory();
		List<ProductDTO> products = statisticsServices.getProductsByMonth(month, category_id, orderby, startPosition, maxResult);
		
		
		modelMap.addAttribute("totalpage",(int)Math.ceil((double)total/LIMIT));
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("products",products);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("month",month);
		modelMap.addAttribute("url", "/admin/statistics/all/"+month+"/"+category_id+"/"+orderby);
		return "statistics";
	}
	
	
	@PostMapping("/shipped")
	public String redirectShippedByMonth(@RequestParam(required = false) String month,@RequestParam int category_id,@RequestParam int orderby ) {	
		if(month==null) {
			return "redirect:/admin/statistics/shipped/"+category_id+"/"+orderby+"/1";
		}
		return "redirect:/admin/statistics/shipped/"+month+"/"+category_id+"/"+orderby+"/1";
	}
	
	@GetMapping("/shipped/{category_id}/{orderby}/{page}")
	public String getProductShippedByMonth(@PathVariable int category_id,@PathVariable int orderby,@PathVariable int page,ModelMap modelMap) {	
		long total = statisticsServices.countTotalProductShipped(category_id);
		int startPosition = (page-1)*LIMIT;
		int maxResult =LIMIT;
		List<Category> categories = categoryServices.getListCategory();
		List<ProductDTO> products = statisticsServices.getProductsShipped(category_id, orderby, startPosition, maxResult);
		
		
		modelMap.addAttribute("totalpage",(int)Math.ceil((double)total/LIMIT));
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("products",products);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("url", "/admin/statistics/all/"+category_id+"/"+orderby);
		return "statisticsShipped";
	}
	
	
	@GetMapping("/shipped/{month}/{category_id}/{orderby}/{page}")
	public String getProductShippedByMonth(@PathVariable String month,@PathVariable int category_id,@PathVariable int orderby,@PathVariable int page,ModelMap modelMap) {	
		long total = statisticsServices.countTotalProductShippedByMonth(month, category_id);
		int startPosition = (page-1)*LIMIT;
		int maxResult =LIMIT;
		List<ProductDTO> products = statisticsServices.getProductsShippedByMonth(month, category_id, orderby, startPosition, maxResult);
		
		
		modelMap.addAttribute("totalpage",(int)Math.ceil((double)total/LIMIT));
		List<Category> categories = categoryServices.getListCategory();
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("products",products);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("month",month);
		modelMap.addAttribute("url", "/admin/statistics/all/"+month+"/"+category_id+"/"+orderby);
		return "statisticsShipped";
	}
	
	@GetMapping("/singleproduct")
	public String singleProduct() {
		return "statisticSingleProduct";
	}
	
	@PostMapping("/redirectSingleproduct")
	public String redirectSingleProduct(@RequestParam int product_id,@RequestParam(required = false) String month) {
		if(month==null) {
			return "redirect:/admin/statistics/singleproduct/"+product_id;
		}
		return "redirect:/admin/statistics/singleproduct/"+product_id+"/"+month;
	}
	
	@GetMapping("/singleproduct/{product_id}")
	public String getSingleProduct(@PathVariable int product_id,ModelMap modelMap) {
		ProductDTO notShipped = statisticsServices.getSingleProduct(product_id,"",0);
		ProductDTO shipped = statisticsServices.getSingleProduct(product_id,"",1);
		ProductDTO canceled = statisticsServices.getSingleProduct(product_id,"",2);
		
		ProductDTO NULL = new ProductDTO();
		NULL.setTotal(0);
		NULL.setTotal_money(0);
		
		if(notShipped==null) {
			notShipped = NULL;
		}
		if(shipped==null) {
			shipped = NULL;
		}
		
		if(canceled==null) {
			canceled = NULL;
		}
		
		
		List<Product_detailDTO> notShippedllDetails =statisticsServices.getSingleProductDetails(product_id,"",0);
		List<Product_detailDTO> shippedDetails =statisticsServices.getSingleProductDetails(product_id,"",1);
		List<Product_detailDTO> canceledDetails =statisticsServices.getSingleProductDetails(product_id,"",2);
		
		
		Product product = productServices.getProduct(product_id);
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("notShipped", notShipped);
		modelMap.addAttribute("shipped", shipped);
		modelMap.addAttribute("canceled", canceled);
		modelMap.addAttribute("product_id", product_id);
		
		
		modelMap.addAttribute("notShippedllDetails", notShippedllDetails);
		modelMap.addAttribute("shippedDetails", shippedDetails);
		modelMap.addAttribute("canceledDetails", canceledDetails);
		
		return "statisticSingleProduct";
	}
	
	@GetMapping("/singleproduct/{product_id}/{month}")
	public String getSingleProduct(@PathVariable int product_id,@PathVariable String month,ModelMap modelMap) {
		ProductDTO notShipped = statisticsServices.getSingleProduct(product_id,month,0);
		ProductDTO shipped = statisticsServices.getSingleProduct(product_id,month,1);
		ProductDTO canceled = statisticsServices.getSingleProduct(product_id,month,2);
		
		List<Product_detailDTO> notShippedllDetails =statisticsServices.getSingleProductDetails(product_id,month,0);
		List<Product_detailDTO> shippedDetails =statisticsServices.getSingleProductDetails(product_id,month,1);
		List<Product_detailDTO> canceledDetails =statisticsServices.getSingleProductDetails(product_id,month,2);
		Product product = productServices.getProduct(product_id);
		System.out.println("++++++++++++++++++++++++/n/n/n/n+++++++++++++/nhihihih"+product.getProduct_name()+"hihihihih/n/n++++++++++++++");
		modelMap.addAttribute("notShipped", notShipped);
		modelMap.addAttribute("shipped", shipped);
		modelMap.addAttribute("canceled", canceled);
		modelMap.addAttribute("product", product);
		
		modelMap.addAttribute("notShippedllDetails", notShippedllDetails);
		modelMap.addAttribute("shippedDetails", shippedDetails);
		modelMap.addAttribute("canceledDetails", canceledDetails);
	
		return "statisticSingleProduct";
	}
	
	@PostMapping("/category")
	public String redirectCategorybyMonth(@RequestParam(required = false) String month ) {	
		if(month=="") {
			return "redirect:/admin/statistics/category/all";
		}
		return "redirect:/admin/statistics/category/"+month;
	}
	
	
	@GetMapping("/category/{month}")
	public String statistic(ModelMap modelMap,@PathVariable(required = false) String month ){
		if(month.compareTo("all")==0) {
			month="";
		}
		List<CategoryStatisticDTO> list = statisticsServices.getStatisticsleCategory(month);
		modelMap.addAttribute("list",list);
		modelMap.addAttribute("month",month);
		return "statisticCategory";

	}
}
