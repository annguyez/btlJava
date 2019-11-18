package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Category;
import com.gr21.entity.Roles;

public interface RolesDAO {
	
	public Roles getRoles(int roles_id);
	public List<Roles> getListRoles();
	public String getRolesName(int roles_id);
	public List<String> getListRolesName();
	public void create(Roles roles );
	public void delete(int roles_id);
	public void update(Roles roles);
	public boolean check(String role_name);
}
