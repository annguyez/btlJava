package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.ColorDAO;
import com.gr21.entity.Color;


@Repository
@Transactional
public class ColorImp implements ColorDAO{

	@Autowired
	SessionFactory sessionFactory;
	public Color getColor(int color_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Color.class, color_id);
	}

	public List<Color> getListColor() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " from Color ";
		Query query = session.createQuery(hql);
		List<Color> list = query.getResultList();
		return list;
	}

	public String getColorName(int color_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();//cau lenh tao bean truy van
		String hql = "select c.color_name from Color c where color_id =  :color_id";
		Query query = session.createQuery(hql);//thuc hien truy van csld
		String color_name = (String) query.getSingleResult();//dua ra ten theo ket qua truy van kieu String
		return null;
	}

	public List<String> getListColorName() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select c,color_name from Color";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Color color) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		session.save(color);
		
	}

	public void delete(int color_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.getColor(color_id));;
		
	}

	public void update(Color color) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Color old = this.getColor(color.getColor_id());
		old.setColor_name(color.getColor_name());
		session.update(old);
		
	}
	
	public boolean checkColor(String color_name) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Color color = (Color) session.createQuery("from Color where color_name='"+color_name+"'").getSingleResult();
			if(color!=null) {
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
