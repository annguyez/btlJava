package com.gr21.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.gr21.entity.Cart;
import com.gr21.entity.Product_detail;
import com.gr21.services.ProductServices;
import com.gr21.services.Product_detailsServices;

@Controller
@SessionAttributes("cart")
public class CartController {
	@Autowired
	Product_detailsServices product_detailsServices;
	
	@Autowired
	ProductServices productServices;
	@GetMapping("addCart")
	@ResponseBody
	public String addCart(String product_detail_id,int quantity,HttpSession session) {
		
		Product_detail detail= product_detailsServices.getProduct_detailByOr(product_detail_id);
		int oldquantity=detail.getQuantity();
		if((oldquantity-quantity)<0) return "false";
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(today);
		int discount=0;
		try {
			discount=productServices.getMaxDiscount(detail.getProduct().getProduct_id(), date);
		}
		catch (Exception e) {
			discount=0;
		}
	
		if(null == session.getAttribute("cart")){
			List<Cart> list = new ArrayList<Cart>();
			Cart cart = new Cart();
			cart.setProduct_name(detail.getProduct().getProduct_name());
			cart.setProduct_id(detail.getProduct().getProduct_id());
			cart.setProduct_detail_id(product_detail_id);
			String price = Double.toString((long)Long.parseLong(detail.getProduct().getPrice())*(100.0-discount)/100);
			cart.setPrice(price);
			cart.setColor_id(detail.getColor().getColor_id());
			cart.setImage(detail.getProduct().getImage());
			cart.setQuantity(1);
			cart.setColor_name(detail.getColor().getColor_name());
			cart.setSize(detail.getSize().getSize());
			cart.setSize_id(detail.getSize().getSize_id());
			list.add(cart);
			session.setAttribute("cart", list);
		}else {
			List<Cart> list = (List<Cart>) session.getAttribute("cart");
			int test = checkCart(list, detail.getProduct().getProduct_id(), detail.getSize().getSize_id(), detail.getColor().getColor_id(), session);
			if(test==-1) {
				if((oldquantity-1)<0) return "false";
				Cart cart = new Cart();
				cart.setProduct_name(detail.getProduct().getProduct_name());
				cart.setProduct_id(detail.getProduct().getProduct_id());
				cart.setProduct_detail_id(product_detail_id);
				String price = Double.toString((long)Long.parseLong(detail.getProduct().getPrice())*(100.0-discount)/100);
				cart.setPrice(price);
				cart.setColor_id(detail.getColor().getColor_id());
				cart.setImage(detail.getProduct().getImage());
				cart.setQuantity(quantity);
				cart.setColor_name(detail.getColor().getColor_name());
				cart.setSize(detail.getSize().getSize());
				cart.setSize_id(detail.getSize().getSize_id());
				list.add(cart);
				session.setAttribute("cart", list);
			}else {
				int new_quantity = list.get(test).getQuantity()+quantity;
				if(oldquantity-new_quantity<0) return "false";
				list.get(test).setQuantity(new_quantity);
			}
			
		}
		return "true";
	}

	private int checkCart(List<Cart> list, int product_id, int size_id, int color_id, HttpSession session) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProduct_id() == product_id && list.get(i).getSize_id() == size_id
					&& list.get(i).getColor_id() == color_id) {
				return i;
			}
		}
		return -1;
	}

	@GetMapping("/deleteCart")
	@ResponseBody
	public void deleteCart(@RequestParam int product_id,@RequestParam int size_id,@RequestParam int color_id,HttpSession session) {
		if(null!=session.getAttribute("cart")) {
			List<Cart> list = (List<Cart>) session.getAttribute("cart");
			int test = checkCart(list, product_id, size_id, color_id, session);
			list.remove(test);
		}
	}
	@GetMapping("/countCart")
	@ResponseBody
	public int countCart(HttpSession session) {
		int count =0;
		if(null == session.getAttribute("cart"))
			return count;
		List<Cart> list = (List<Cart>) session.getAttribute("cart");
		
		for(Cart cart:list) {
			count += cart.getQuantity();
		}
		return count;
	}

}
