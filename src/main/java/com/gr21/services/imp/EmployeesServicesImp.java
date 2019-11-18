package com.gr21.services.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.EmployeesDAO;
import com.gr21.entity.Employees;
import com.gr21.services.*;
@Service
public class EmployeesServicesImp implements EmployeesServices{

	@Autowired
	EmployeesDAO employeesDAO;
	public List<Employees> getListEmployees() {
		// TODO Auto-generated method stub
		return employeesDAO.getListEmployees();
	}

	public List<String> getListEmployeesName() {
		// TODO Auto-generated method stub
		return employeesDAO.getListEmployeesName();
	}

	public void delete(int employees_id) {
		// TODO Auto-generated method stub
		employeesDAO.delete(employees_id);
	}

	public void create(Employees employee) {
		// TODO Auto-generated method stub
		employeesDAO.create(employee);
	}

	public void update(Employees employees) {
		// TODO Auto-generated method stub
		employeesDAO.update(employees);
	}

	public int getLastest() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Employees getEmployees(int employees_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> getEmployeess(int employees_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employees> getListEmployees(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCountEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		boolean check =  employeesDAO.checkLogin(username, password);
		return check;
	}

	public Employees getEmployee(int employees_id) {
		// TODO Auto-generated method stub
		return employeesDAO.getEmployee(employees_id);
	}

	public boolean check(String username) {
		// TODO Auto-generated method stub
		boolean check = employeesDAO.check(username);
		return check;
	}

	public boolean searchEmp(int employees_id) {
		// TODO Auto-generated method stub
		boolean search = employeesDAO.searchEmp(employees_id);
		return search;
	}

}
