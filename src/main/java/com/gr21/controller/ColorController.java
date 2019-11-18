package com.gr21.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessageContext;
import javax.swing.JOptionPane;

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
import com.gr21.entity.Color;
import com.gr21.entity.Product_detail;
import com.gr21.services.ColorServices;

@Controller
@RequestMapping("/admin/color")
public class ColorController {

	@Autowired
	ColorServices colorServices;
	
	// láº¥y danh sÃ¡ch mÃ u
	@GetMapping
	
	public String viewColor(ModelMap modelMap) {
		List<Color> list = colorServices.getListColor();
		modelMap.addAttribute("list",list);
		return "color";
	}
	//ThÃªm mÃ u
	@PostMapping("/color")

	@ResponseBody
	public String addColor(@RequestParam String colorJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jsonNode = mapper.readTree(colorJson);
			String a = jsonNode.get("color_name").asText();
			
			boolean check = colorServices.checkColor(a);
			if(check) {
				 
				System.out.println("Tên màu đã tồn tại!!");
				
				
			}else {
				Color color = new Color();
				color.setColor_name(jsonNode.get("color_name").asText());
				colorServices.create(color);
				//modelMap.addAttribute("check", "Thêm màu thành công!!!");
				System.out.println( "Thêm màu thành công!!!");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "color";
	}
	//XÃ³a
	@GetMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int color_id) {
		colorServices.delete(color_id);
		return "true";
		
	}
	//cáº­p nháº­t
		@PostMapping("/update")

		@ResponseBody
		public String updateColor(@RequestParam String colorJson) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(colorJson);
				boolean check = colorServices.checkColor(jsonNode.get("color_name").asText());
				if(check) {
					System.out.println("Update fail");
				}else {
					Color color = new Color();
					
					color.setColor_name(jsonNode.get("color_name").asText());
					color.setColor_id(jsonNode.get("color_id").asInt());
					
					colorServices.update(color);
					System.out.println("update done");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "color";
		}
	
	
}
