package com.gr21.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gr21.entity.Cart;
import com.gr21.entity.Category;
import com.gr21.entity.Color;
import com.gr21.entity.Product;
import com.gr21.entity.Size;
import com.gr21.model.SizeDTO;
import com.gr21.services.CategoryServices;
import com.gr21.services.Product_detailsServices;
import com.gr21.services.imp.ProductServicesImpl;

@Controller
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@SessionAttributes("cart")
@RequestMapping(value = "/details")
public class Test {
	
	@Autowired
	ProductServicesImpl productService;
	@Autowired
	Product_detailsServices productDetailService;
	@Autowired
	CategoryServices categoryServices;
	@GetMapping(value = "/{product_id}")
	public String getDetailProduct(@PathVariable int product_id,Model m,HttpSession session) {
		Product pr = productService.getProductDetailById(product_id);
		m.addAttribute("pr", pr);
		List<Category> categories = categoryServices.getListCategory();
		m.addAttribute("category", categories);
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(today);
		int discount=0;
		try {
			discount=productService.getMaxDiscount(product_id, date);
		}
		catch (Exception e) {
			discount=0;
		}
		m.addAttribute("discount", discount);
		if(null != session.getAttribute("cart")) {
			List<Cart> list = (List<Cart>) session.getAttribute("cart");
			m.addAttribute("countProduct",list.size());
		}
		List<Color> colors =productDetailService.getColor(product_id);
		for(Color color:colors) {
			System.out.println(color.getColor_name());
		}
		m.addAttribute("colors",colors);

		return "detailsProduct";
	}
	@GetMapping(value = "/changeSize")
	@ResponseBody
	public String getSizeByColor(@RequestParam int product_id, @RequestParam int color_id) {
		
		List<Size> list = productDetailService.getSizeByColor(color_id, product_id); 
		String data ="";
		for(Size size:list) {
			data+="<option value='"+size.getSize_id()+"'> Size : "+size.getSize()+"</option>";
		}
		return data;
	}
}
