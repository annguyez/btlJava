package com.gr21.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.ColorDAO;

import com.gr21.entity.Color;
import com.gr21.services.ColorServices;
@Service
public class ColorServicesImpl implements ColorServices{

	@Autowired
	ColorDAO colorDAO;
	
	public List<Color> getListColor() {
		// TODO Auto-generated method stub
		return colorDAO.getListColor();
	}
	public void delete(int color_id) {
		// TODO Auto-generated method stub
		colorDAO.delete(color_id);
	}
	public void create(Color color_id) {
		// TODO Auto-generated method stub
		colorDAO.create(color_id);
	}
	public void update(Color color_id) {
		// TODO Auto-generated method stub
		colorDAO.update(color_id);
	}
	public int getLastest() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Color getColor(int color_id) {
		// TODO Auto-generated method stub
		return colorDAO.getColor(color_id);
	}
	public boolean checkColor(String color_name) {
		// TODO Auto-generated method stub
		boolean check = colorDAO.checkColor(color_name);
		return check;
	}
	
}
