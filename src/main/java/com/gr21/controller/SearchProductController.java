package com.gr21.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gr21.entity.Category;
import com.gr21.entity.Product;
import com.gr21.model.ProductDTO;
import com.gr21.services.imp.CategoryServicesImp;
import com.gr21.services.imp.ProductServicesImpl;

@Controller
public class SearchProductController {
	
	public static final int LIMIT = 18;
	@Autowired
	ProductServicesImpl productService;
	@Autowired
	CategoryServicesImp categoryService;
	@RequestMapping(value = "/searchByLikeName", method = RequestMethod.POST)
	public String getProductByLikeName(@RequestParam String name,Model m ) {
		return "redirect:/search/0/0/0/"+name+"/2/1";
	}
	
	@GetMapping(value = "/search/{category_id}/{minPrice}/{maxPrice}/{name}/{orderby}/{page}")
	public String getListProduct(Model m,@PathVariable int category_id,@PathVariable int minPrice,@PathVariable int maxPrice,
			@PathVariable String name,@PathVariable int orderby,@PathVariable int page) {
		List<Category> listCategory = categoryService.getListCategory();
		m.addAttribute("category", listCategory);
		
		int startPosition = (page-1)*LIMIT;
		List<ProductDTO> list = productService.multiSearch(category_id, minPrice, maxPrice, name, orderby, startPosition, LIMIT);
		int total = productService.countMultiSearch(category_id, minPrice, maxPrice, name, orderby);
	
		int totalpage = (int)Math.ceil((double)total/LIMIT);
		m.addAttribute("totalpage",totalpage);
		
		m.addAttribute("product", list);
		m.addAttribute("category_id", category_id);
		m.addAttribute("minPrice", minPrice);
		m.addAttribute("maxPrice", maxPrice);
		m.addAttribute("name", name);
		m.addAttribute("orderby",orderby);
		m.addAttribute("total",total);
		m.addAttribute("page",page);
		
		String url="/search/"+category_id+"/"+minPrice+"/"+maxPrice+"/"+name+"/"+"/"+orderby;
		m.addAttribute("url",url);
		return "shop";
		
	}
	
	
	@GetMapping(value = "/search/{category_id}/{minPrice}/{maxPrice}/{orderby}/{page}")
	public String getListProduct(Model m,@PathVariable int category_id,@PathVariable int minPrice,@PathVariable int maxPrice,
			@PathVariable int orderby,@PathVariable int page) {
		List<Category> listCategory = categoryService.getListCategory();
		m.addAttribute("category", listCategory);
		
		int startPosition = (page-1)*LIMIT;
		List<ProductDTO> list = productService.multiSearch(category_id, minPrice, maxPrice,"", orderby, startPosition, LIMIT);
		int total = productService.countMultiSearch(category_id, minPrice, maxPrice, "", orderby);
		int totalpage = (int)Math.ceil((double)total/LIMIT);
		m.addAttribute("totalpage",totalpage);
		m.addAttribute("product", list);
		m.addAttribute("category_id", category_id);
		m.addAttribute("minPrice", minPrice);
		m.addAttribute("maxPrice", maxPrice);
		m.addAttribute("name", "");
		m.addAttribute("orderby",orderby);
		m.addAttribute("total",total);
		m.addAttribute("page",page);
		
		String url="/search/"+category_id+"/"+minPrice+"/"+maxPrice+"/"+orderby;
		m.addAttribute("url",url);
		return "shop";
		
	}
	
}
