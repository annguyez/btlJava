package com.gr21.controller;

import java.io.IOException;
import java.util.List;

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
import com.gr21.entity.Roles;
import com.gr21.entity.Size;
import com.gr21.services.RolesServices;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
	@Autowired
	RolesServices rolesServices;
	//Láº¥y danh sÃ¡ch
	 @GetMapping
	 public String viewSize(ModelMap modelMap) {
			List<Roles> list = rolesServices.getListRoles();
			modelMap.addAttribute("list",list);
			return "role";
		}
	//Theem Role
	 @PostMapping("/role")
	 @ResponseBody
	 public String addRole(@RequestParam String roleJson) {
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			JsonNode jsonNode = mapper.readTree(roleJson);
			boolean check = rolesServices.check(jsonNode.get("role_name").asText());
			if(check) {
				System.out.println("Thêm thất bại");
			}else {
				Roles role = new Roles();
				role.setRole_name(jsonNode.get("role_name").asText());
				rolesServices.create(role);
				System.out.println("Thêm thành công");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "role";
	 }



		@GetMapping("/delete")
		@ResponseBody
		public String delete(@RequestParam int role_id) {
			rolesServices.delete(role_id);
			return "true";
			
		}

		@PostMapping("/update")
		@ResponseBody
		public String updateRole(@RequestParam String roleJson) {
			 ObjectMapper mapper = new ObjectMapper();
			 try {
				JsonNode jsonNode = mapper.readTree(roleJson);
				boolean check = rolesServices.check(jsonNode.get("role_name").asText());
				if(check) {
					System.out.println("Update fail");
				}else {
					Roles role = new Roles();
					role.setRole_name(jsonNode.get("role_name").asText());
					role.setRole_id(jsonNode.get("role_id").asInt());
					rolesServices.update(role);
					System.out.println("update done");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return "role";
}


}








