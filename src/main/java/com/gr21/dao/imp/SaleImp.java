package com.gr21.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.SaleDAO;
import com.gr21.entity.Category;
import com.gr21.entity.Sale;
@Transactional
@Repository
public class SaleImp implements SaleDAO{

	@Autowired
	SessionFactory sessionFactory;
	public Sale getSale(int sale_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Sale.class, sale_id);

	}

	public List<Sale> getListSale() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Sale";
		Query query = session.createQuery(hql);
		List<Sale> list = query.getResultList();
		return list;
	}
	
	
	public List<Sale> getListSale(int startPosition,int maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Sale";
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Sale> list = query.getResultList();
		return list;
	}
	

	public String getSaleName(int sale_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.sale_name from Sale c where sale_id = :sale_id";
		Query query = session.createQuery(hql);
		String sale_name = (String) query.getSingleResult();
		return sale_name;
	}

	public List<String> getListSaleName() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.sale_name from Sale c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Sale sale) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.save(sale);
		
	}

	public void delete(int sale_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.delete(this.getSale(sale_id));	
		
	}

	public void update(Sale sale) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.update(sale);
	}

	public long countTotalSale() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(s.sale_id) from Sale s";
		return (Long) session.createQuery(hql).getSingleResult();
	}
	
	public long countSale(String command,int product_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(s.sale_id) from Sale s";
		if(product_id!=0) {
			hql+=" join s.products p ";
		}
		hql+=command;		
		if(command=="") {
			if(product_id!=0) {
				hql+=" where ";
			}
		}else {
			if(product_id!=0)
			hql+=" and ";
		}
		if(product_id!=0) {
			hql+=" p.product_id = "+product_id;
		}
		hql+=" group by s.sale_id order by s.sale_id";
		try {
			return (Long) session.createQuery(hql).getSingleResult();
		}
		catch (Exception e) {
			return (long) 0;
		}
	}
	
	public List<Sale> getListSale(String command,int product_id,int startPosition,int maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select s from Sale s  ";
		if(product_id!=0) {
			hql+=" join s.products p ";
		}
		hql+=command;		
		if(command=="") {
			if(product_id!=0) {
				hql+=" where ";
			}
		}else {
			if(product_id!=0)
			hql+=" and ";
		}
		if(product_id!=0) {
			hql+=" p.product_id = "+product_id;
		}
		hql+=" group by s.sale_id order by s.sale_id";
		List<Sale> list = new ArrayList<Sale>();
		try {
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		
			list = query.getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			list= null;
		}
		return list;
	}
}
