package com.gr21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	@GetMapping("/login")
	public String login(@RequestParam (required = false)String error,ModelMap modelMap) {
		String message="";
		try {
			if(error.compareToIgnoreCase("Fail")==0) {
				message="Tên đăng nhập hoặc mật khẩu không đúng ";
			
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		modelMap.addAttribute("message",message);
		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login";
	}
}
