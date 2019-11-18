package com.gr21.services;

import java.util.List;

import com.gr21.entity.Color;
import com.gr21.entity.Product;

public interface ColorServices {
	public List<Color> getListColor();
	public void delete(int color_id);
	public void create(Color color_id );
	public void update(Color color_id );
	public int getLastest();
	public Color getColor(int color_id);
	
	public boolean checkColor(String color_name);
	
}
