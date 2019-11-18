package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Size;

public interface SizeDAO {
	public Size getSize(int size_id);
	public List<Size> getListSize();
	public String getSizeName(int size_id);
	public List<String> getListSizeName();
	public void create(Size size);
	public void delete(int size_id);
	public void update(Size size);
	
	public boolean check(String size_name);

}
