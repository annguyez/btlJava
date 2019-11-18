package com.gr21.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@GetMapping
	public String Default() {
		return "upload";
	}

	@Autowired
	ServletContext servletContext;

	@PostMapping("/productImg")
	@ResponseBody
	public String UploadProductImg(MultipartHttpServletRequest request) {

		String path = servletContext.getRealPath("resources/image/products/");
		System.out.println(path);
		String location = "resources/image/products/";
		Upload(request, location);
		return "true";
	}

	public Boolean Upload(MultipartHttpServletRequest request, String location) {

		String path = servletContext.getRealPath(location);
	//	System.out.println(path);
		Iterator<String> imgNames = request.getFileNames();
		MultipartFile mpf = request.getFile(imgNames.next());
		File file = new File(path + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
