package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Color;

public interface ColorDAO {
	public Color getColor(int color_id);
	public List<Color> getListColor();
	public String getColorName(int color_id);
	public List<String> getListColorName();
	public void create(Color color);
	public void delete(int color_id);

	public void update(Color color);
	public boolean checkColor(String color_name);
}
