package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.SizeDAO;
import com.gr21.entity.Color;
import com.gr21.entity.Size;
@Transactional
@Repository
public class SizeImp implements SizeDAO {

	@Autowired
	SessionFactory sessionFactory;
	public Size getSize(int size_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Size.class, size_id);
	}

	public List<Size> getListSize() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql="from Size";
		Query query = session.createQuery(hql);
		List<Size> list = query.getResultList();
		return list;
	}

	public String getSizeName(int size_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " select c.size_name from Size c where size_id =:size_id";
		Query query = session.createQuery(hql);
		String size_name = (String) query.getSingleResult();
		return size_name;
	}

	public List<String> getListSizeName() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.size_name from Size c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Size size) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.save(size);
	}

	public void delete(int size_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.delete(this.getSize(size_id));	
	}

	public void update(Size size) {
		// TODO Auto-generated method stub
		Size old = this.getSize(size.getSize_id());
		old.setSize(size.getSize());
		Session session = sessionFactory.getCurrentSession();	
		session.update(old);
	}
	public boolean check(String size_name) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Size size = (Size) session.createQuery("from Size where size='"+size_name+"'").getSingleResult();
			if(size!=null) {
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
