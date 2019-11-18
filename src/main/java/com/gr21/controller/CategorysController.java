package com.gr21.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gr21.entity.Category;
import com.gr21.entity.Product_detail;
import com.gr21.services.CategoryServices;

@Controller
@RequestMapping("/admin/category_ad")
public class CategorysController {

	@Autowired
	CategoryServices CategoryServices;
	
	// 
	@GetMapping
	
	public String viewCategory(ModelMap modelMap) {
		List<Category> list = CategoryServices.getListCategory();
		modelMap.addAttribute("list",list);
		return "category_ad";
	}
	//ThÃªm mÃ u
	@PostMapping("/category")

	@ResponseBody
	public String addCategory(@RequestParam String categoryJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jsonNode = mapper.readTree(categoryJson);
			boolean check = CategoryServices.check(jsonNode.get("category_name").asText());
			if(check) {
				System.out.println("Thêm thất bại");
			}else {
				Category Category = new Category();
				Category.setCategory_name(jsonNode.get("category_name").asText());
				CategoryServices.create(Category);
				System.out.println("Thêm thành công");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "category_ad";
	}
	//XÃ³a
	@GetMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int category_id) {
		CategoryServices.delete(category_id);
		return "true";
		
	}
	//cáº­p nháº­t
		@PostMapping("/update")

		@ResponseBody
		public String updateCategory(@RequestParam String categoryJson) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(categoryJson);
				boolean check = CategoryServices.check(jsonNode.get("category_name").asText());
				if(check) {
					System.out.println("update fail");
				}else {
					Category category = new Category();
					
					category.setCategory_name(jsonNode.get("category_name").asText());
					
					category.setImage("");
					category.setCategory_id(jsonNode.get("category_id").asInt());
					CategoryServices.update(category);
					System.out.println("Update done");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "category_ad";
		}
	
	
}
