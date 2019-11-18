package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.EmployeesDAO;

import com.gr21.entity.Employees;

@Repository
@Transactional
public class EmployeesImp  implements EmployeesDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Employees getEmployees(int employees_id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employees.class, employees_id);
	}
	public boolean searchEmp(int employees_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Employees employees = (Employees) session.createQuery("from Employees where employee_id = '"+employees_id+"'").getSingleResult();
			if(employees!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public List<Employees> getListEmployees() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Employees";
		Query query = session.createQuery(hql);
		List<Employees> list = query.getResultList();
		for(Employees value :list) {
			System.out.println(value.getFullname());
		}
		return list;
	}

	public String getEmployeesName(int employees_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.employees_name from Employees c where employees_id = :employees_id";
		Query query = session.createQuery(hql);
		String employees_name = (String) query.getSingleResult();
		return employees_name;
	}
	public Employees getEmployee(int employees_id) {
		Session session = sessionFactory.getCurrentSession();
		Employees employees = (Employees) session.createQuery("from Employees where employee_id = '"+employees_id+"'").getSingleResult();
		return employees;
	}

	public List<String> getListEmployeesName() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.username from Employees c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Employees employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.save(employee);
	}

	public void delete(int employees_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.delete(this.getEmployees(employees_id));	
	}

	public void update(Employees employees) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.update(employees);
	}

	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Employees employees = (Employees) session.createQuery("from Employees where username='"+username+"'AND password='"+password+"'" ).getSingleResult();
		try {
			if(employees != null) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
		
	}
	public boolean check(String username) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Employees employee = (Employees) session.createQuery("from Employees where username='"+username+"'").getSingleResult();
			if(employee!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	

}
