package com.gr21.services;

import java.util.List;

import com.gr21.entity.Employees;

public interface EmployeesServices {

	public List<Employees> getListEmployees();
	public List<String> getListEmployeesName();
	
	public void delete(int employees_id);

	public void create(Employees employee);
	public void update(Employees employees );
	public int getLastest();
	public Employees getEmployees(int employees_id);
	
	public List<Object[]> getEmployeess(int employees_id);
	public List<Employees> getListEmployees(int startPosition,int maxResult);
	
	public Long getCountEmployees();
	public boolean checkLogin(String username, String password);
	public Employees getEmployee(int employees_id);
	
	public boolean check(String username);
	public boolean searchEmp(int employees_id);
}
