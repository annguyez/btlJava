package com.gr21.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.entity.Roles;
import com.gr21.services.RolesServices;
import com.gr21.dao.*;
@Service
public class RolesServicesImp implements RolesServices{

	@Autowired
	RolesDAO rolesDAO;
	public List<Roles> getListRoles() {
		// TODO Auto-generated method stub
		return rolesDAO.getListRoles();
	}

	public void delete(int role_id) {
		// TODO Auto-generated method stub
		rolesDAO.delete(role_id);
	}

	public void create(Roles role_id) {
		// TODO Auto-generated method stub
		rolesDAO.create(role_id);
	}

	public void update(Roles role_id) {
		// TODO Auto-generated method stub
		rolesDAO.update(role_id);
	}

	public int getLastest() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Roles getRole(int role_id) {
		// TODO Auto-generated method stub
		return rolesDAO.getRoles(role_id);
	}

	public boolean check(String role_name) {
		// TODO Auto-generated method stub
		boolean check = rolesDAO.check(role_name);
		return check;
	}

}
