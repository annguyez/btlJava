package com.gr21.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gr21.entity.Color;
import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;
import com.gr21.entity.Product;
import com.gr21.entity.Product_detail;
import com.gr21.services.OrderService;
import com.gr21.services.Orders_detailService;
import com.gr21.services.ProductServices;
import com.gr21.services.Product_detailsServices;

@Controller
@RequestMapping("/admin/order")
@Transactional
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductServices productServices;
	@Autowired
	Product_detailsServices product_detailsServices;
	@Autowired
	Orders_detailService orders_detailService;
	@GetMapping("/{page}")
	public String viewListOrder(@PathVariable int page,ModelMap modelMap) {
		List<Orders> list = orderService.getListOrders((page-1)*5,5);
		Long total = orderService.countOder();
		total = (long) Math.ceil((double)total/5);
		System.out.println(total);
		modelMap.addAttribute("list",list);
		modelMap.addAttribute("total",total);
		
		return "order";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int order_id) {
		orderService.delete(order_id);
		return "true";
		
	}
	
	@GetMapping("/deletepr")
	@ResponseBody
	public String deletepr(@RequestParam String product_detail_id) {
		orders_detailService.delete(product_detail_id);
		return "true";
		
	}
//	@GetMapping
//	public String view(ModelMap modelMap) {
//		List<Orders> list = orderService.getListOrdersByStatus();
//		modelMap.addAttribute("list", list);
////		for(Orders list1: list) {
////			System.out.println("---------");
////			System.out.println(list);
////		}
//		return "order";
//	}
//	@GetMapping("/add")
//	public String viewListStatus(ModelMap modelMap) {
//		List<String> listStt = orderService.getListOrderStatus();
//		modelMap.addAttribute("listStt", listStt);
////		System.out.println("---------");
////		for(String x : list ) {
////			System.out.println(x);
////		}
//		return "order";
//	}
	@GetMapping("/info/{orders_id}")
	public String getInfor(@PathVariable int orders_id,ModelMap modelMap) {
		
		Orders order = orderService.getOrders(orders_id);
		System.out.println(order.getCustomer_name());
		List<Orders_detail> orders_detail =orderService.getOrders_detail(orders_id);
		
		int a = 0;
	
		List<Product_detail>  product_details = new ArrayList<Product_detail>();
		for(Orders_detail o:orders_detail) {
			String product_detail_id="";
			Product_detail prr = new Product_detail();
				product_detail_id = o.getOrders_detail_id().getProduct_detail_id();
					prr= product_detailsServices.getProduct_detailByOr(product_detail_id);	
					product_details.add(prr);
					System.out.println(product_detail_id);
		
		}
		for(Product_detail detail:product_details) {
			System.out.println(detail.getQuantity());
		}
	
		
		
		String name = order.getCustomer_name();
		String phone = order.getPhone();
		String addr = order.getAddress();
		String note = order.getNote();
		
		modelMap.addAttribute("product_details", product_details);
		
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("a", a);
		modelMap.addAttribute("phone", phone);
		modelMap.addAttribute("addr", addr);
		modelMap.addAttribute("note", note);
		modelMap.addAttribute("orders_detail", orders_detail);
		System.out.println("thong bao");
	
		return "orderInfo";
	}
	@PostMapping("searchPr")
	public String searchProduct(@RequestParam int pr_id, ModelMap modelMap) {
		List<Product_detail> listPr = product_detailsServices.getProduct_detailsByProduct_id(pr_id);
		List<Orders_detail> listOr = new ArrayList<Orders_detail>();
		for(Product_detail li : listPr) {
			String product_detail_id = "";
			List<Orders_detail> listOr1 = new ArrayList<Orders_detail>();
			product_detail_id = li.getProduct_detail_id();
			listOr1 = orders_detailService.getListOrders_detailbyId(product_detail_id);
			for(Orders_detail ii : listOr1) {
				System.out.println(ii.getPrice()+"sdadada");
			}
			listOr.addAll(listOr1);
			System.out.println(li.getProduct_detail_id()+"-------");
			
		}
		for(Orders_detail i : listOr) {
			System.out.println(i.getPrice()+"sdadada");
		}
		modelMap.addAttribute("listPr", listPr);
		modelMap.addAttribute("listOr", listOr);
		return "SearchPr";
	}
	@PostMapping("/search")
	public String searchOrder(@RequestParam int search_orderid,ModelMap modelMap) {
		boolean search = orderService.searchOrders(search_orderid);
		if(search) {
			Orders order = orderService.getOrders(search_orderid);
			int id = order.getOrders_id();
			String name = order.getCustomer_name();
			String address = order.getAddress();
			String phone = order.getPhone();
			int status = order.getOrders_status();
			String date = order.getOrders_date();
			String note = order.getNote();
			
			String tb= "Kết quả tìm kiếm với Mã hóa đơn: " +id;
		
			modelMap.addAttribute("tb", tb);
			modelMap.addAttribute("id", id);
			modelMap.addAttribute("name", name);
			modelMap.addAttribute("address", address);
			modelMap.addAttribute("phone", phone);
			modelMap.addAttribute("status", status);
			
			modelMap.addAttribute("date", date);
			modelMap.addAttribute("note", note);
		}else {
			System.out.println("Tìm kiếm thất bại");
			String tbb = "Không có hóa đơn";
			modelMap.addAttribute("tbb", tbb);
		}
		
	
		return"SearchOrder";
	}
	@PostMapping("/update")
	public String update(@RequestParam int order_id,@RequestParam int order_status) {
		
//			Orders order = orderService.getOrders(order_id);
//			//Orders order = new Orders();
//			order.setOrders_id(order_id);
//			System.out.println(order.getOrders_id());
//			order.setOrders_status(order_status);
//			orderService.update(order);
//		Session session = sessionFactory.getCurrentSession();
//		Orders order = (Orders) session.createQuery("from Orders where orders_id = '"+order_id+"'").getSingleResult();
		Orders order = orderService.getOrders(order_id);
		order.setOrders_id(order_id);
		System.out.println(order.getOrders_id());
		
		order.setOrders_status(order_status);
		orderService.update(order);
//		System.out.println("---------");
//		System.out.println(order.getOrders_status());
		return"redirect:/admin/order/1";
	}
}
