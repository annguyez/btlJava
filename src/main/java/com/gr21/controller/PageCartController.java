package com.gr21.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gr21.entity.Cart;
import com.gr21.entity.Category;
import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;
import com.gr21.entity.Orders_detail.Orders_detail_id;
import com.gr21.services.imp.CategoryServicesImp;
import com.gr21.services.imp.OrderServiceImpl;
import com.gr21.services.imp.Orders_detailServiceImpl;

@Controller
@RequestMapping("/cart")
public class PageCartController {
	@Autowired
	OrderServiceImpl orderService;
	
	@Autowired
	Orders_detailServiceImpl order_detailService;
	@Autowired
	CategoryServicesImp categoryService;
	@GetMapping
	public String viewCart(Model m,HttpSession session) {
		List<Category> listCategory = categoryService.getListCategory();
		m.addAttribute("category", listCategory);
		
		if(null != session.getAttribute("cart")) {
			List<Cart> list = (List<Cart>) session.getAttribute("cart");
			m.addAttribute("cart", list);
			m.addAttribute("countProduct",list.size());
		}
		
		return "cart";
	}
}
