package com.gr21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gr21.entity.Category;
import com.gr21.entity.Product;
import com.gr21.model.ProductDTO;
import com.gr21.services.imp.CategoryServicesImp;
import com.gr21.services.imp.ProductServicesImpl;

@Controller
@RequestMapping(value = {"home","/"})
public class HomeController {
	@Autowired
	ProductServicesImpl productService;
	
	@Autowired
	CategoryServicesImp categoryService;
	
	@GetMapping

	public String getListProduct(Model m) {
		List<Category> listCategory = categoryService.getListCategory();
		m.addAttribute("category", listCategory);
		List<Product> list = productService.getListProduct();
		List<ProductDTO> newest = productService.getListNewest(0,0,15);
		
		List<ProductDTO> bestseller = productService.getBestSeller(0, 0, 15);
		
		m.addAttribute("newest", newest);
		m.addAttribute("bestseller", bestseller);
		m.addAttribute("pr", list);
		return "index";
		
	}
}
