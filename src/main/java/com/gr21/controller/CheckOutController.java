package com.gr21.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ParseState;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gr21.entity.Cart;
import com.gr21.entity.Category;
import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;
import com.gr21.entity.Orders_detail.Orders_detail_id;
import com.gr21.entity.Product_detail;
import com.gr21.services.Product_detailsServices;
import com.gr21.services.imp.CategoryServicesImp;
import com.gr21.services.imp.OrderServiceImpl;
import com.gr21.services.imp.Orders_detailServiceImpl;
import com.gr21.services.imp.SendMailServiceImpl;

@Controller
public class CheckOutController {
	@Autowired
	OrderServiceImpl orderService;
	
	@Autowired
	Orders_detailServiceImpl order_detailService;
	
	@Autowired
	SendMailServiceImpl sendMailService;
	@Autowired
	Product_detailsServices product_detailsServices;
	
	@Autowired
	CategoryServicesImp categoryService;
	
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(Model m,HttpSession session) {
		List<Category> listCategory = categoryService.getListCategory();
		m.addAttribute("category", listCategory);
		if(null != session.getAttribute("cart")) {
			List<Cart> list = (List<Cart>) session.getAttribute("cart");
			m.addAttribute("cart", list);
			m.addAttribute("countProduct",list.size());
		}
		
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkOut(@RequestParam String customer_name,@RequestParam String address,@RequestParam String note,@RequestParam String phone, HttpSession session) 
	{
		if(null != session.getAttribute("cart")) {
			List<Cart> cart = (List<Cart>) session.getAttribute("cart");
			Orders ord = new Orders();
			ord.setCustomer_name(customer_name);
			ord.setAddress(address);
			ord.setNote(note);
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
			ord.setOrders_date(format.format(calendar.getTime()));
			ord.setPhone(phone);
			int order_id = orderService.addOrder(ord);
			if(order_id > 0) {
				System.out.println("đã thêm");
				Set<Orders_detail> listDetails = new HashSet<Orders_detail>();
				
				for(Cart carts : cart) {
					Orders_detail_id detailId = new Orders_detail_id();
					detailId.setProduct_detail_id(carts.getProduct_detail_id());
					detailId.setOrders_id(ord.getOrders_id());
					
					Orders_detail detail = new Orders_detail(); 
					detail.setOrders_detail_id(detailId);
					detail.setPrice(carts.getPrice());
					detail.setQuantity(carts.getQuantity());
					
					Product_detail  pro= product_detailsServices.getProduct_detailByOr(carts.getProduct_detail_id());
					int quantity= pro.getQuantity()-carts.getQuantity();
					if(quantity>=0) {
						pro.setQuantity(quantity);
						product_detailsServices.update(pro);
						order_detailService.AddOrderDetail(detail);
//						sendMailService.sendEmail("testthoima1123@gmail.com",
//												"kienhieu98@gmail.com", 
//												"Thank you for your purchase at Group 21",
//								"\r\n" + 
//								"Hi\r\n" + 
//								"\r\n" + 
//								"Thank you for buying Group 21."
//								+ " Hope you have a great experience at our store");
					}
					
				}
				session.removeAttribute("cart");
			}else {
				System.out.println("chưa thêm");
			};
			return "thankiu";
		}
		else return "redirect:/";
	}
	
	
}
