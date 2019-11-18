package com.gr21.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gr21.entity.Category;
import com.gr21.entity.Color;
import com.gr21.entity.Product;
import com.gr21.entity.Product_detail;
import com.gr21.entity.Size;
import com.gr21.model.SizeDTO;
import com.gr21.services.SizeServices;

@Controller
@RequestMapping("/admin/size")
public class SizeController {
	@Autowired
	SizeServices sizeServices;
	//láº¥y danh sÃ¡ch size

	@GetMapping
	public String viewSize(ModelMap modelMap) {
		List<Size> list = sizeServices.getListSize();
		modelMap.addAttribute("list",list);
		return "size";
	}
	//Them size
	@PostMapping("/size")
	@ResponseBody
	public String addSize(@RequestParam String sizeJson) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			JsonNode  jsonNode = mapper.readTree(sizeJson);
			boolean check = sizeServices.check(jsonNode.get("size").asText());
			if(check) {
				System.out.println("Thêm Size thất bại");
				
			}else {
				Size size1 = new Size();
				//ThÃ´ng tin size
				size1.setSize(jsonNode.get("size").asText());
				
				sizeServices.create(size1);
				System.out.println("Thêm thành công");
			}
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "size";
//		System.out.println(sizeJson);
//		return "addSize";
	}
	@GetMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int size_id) {
		sizeServices.delete(size_id);
		return "true";
		
	}
//	@GetMapping("/update")
//	@ResponseBody
//	public SizeDTO getinfo(@RequestParam int size_id) {
//		SizeDTO sizeDTO = new SizeDTO();
//		Size size = sizeServices.getSize(size_id);
//		sizeDTO.setSize_id(size_id);
//		System.out.println(size.getSize());
//		sizeDTO.setSize(size.getSize());
//		return sizeDTO;
//		
//		
//	}
//	@PostMapping("/update")
//	@ResponseBody
//	public String updateSize(@RequestParam String sizeJson) {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			JsonNode  jsonNode = mapper.readTree(sizeJson);
//			Size size = new Size();
//			//Thong tin
//			int size_id = jsonNode.get("size_id").asInt();
//			size.setSize_id(size_id);
//			size.setSize(jsonNode.get("size").asText());
//			sizeServices.update(size);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return"size";
//	}
	
	
	@PostMapping("/update")
	@ResponseBody
	public String updateSize(@RequestParam String sizeJson) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			JsonNode  jsonNode = mapper.readTree(sizeJson);
			boolean check = sizeServices.check(jsonNode.get("size").asText());
			if(check) {
				System.out.println("update fail");
			}else {
				Size size1 = new Size();
				//ThÃ´ng tin size
				
				size1.setSize(jsonNode.get("size").asText());
				size1.setSize_id(jsonNode.get("size_id").asInt());
				sizeServices.update(size1);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "size";
//		System.out.println(sizeJson);
//		return "addSize";
	}
}
