package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.RolesDAO;
import com.gr21.entity.Category;
import com.gr21.entity.Roles;
@Repository
@Transactional
public class RolesImp implements RolesDAO{

	@Autowired
	SessionFactory sessionFactory;
	public Roles getRoles(int roles_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Roles.class, roles_id);
	}

	public List<Roles> getListRoles() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Roles";
		Query query = session.createQuery(hql);
		List<Roles> list = query.getResultList();
		return list;
	}

	public String getRolesName(int roles_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.roles_name from Roles c where roles_id = :roles_id";
		Query query = session.createQuery(hql);
		String roles_name = (String) query.getSingleResult();
		return roles_name;
	}

	public List<String> getListRolesName() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.roles_name from Roles c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Roles roles) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.save(roles);
	}

	public void delete(int roles_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.delete(this.getRoles(roles_id));	
	}

	public void update(Category roles) {
		// TODO Auto-generated method stub
		
	}

	public void update(Roles roles) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.update(roles);
	}
	public boolean check(String role_name) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Roles role = (Roles) session.createQuery("from Roles where role_name='"+role_name+"'").getSingleResult();
			if(role!=null) {
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

}
