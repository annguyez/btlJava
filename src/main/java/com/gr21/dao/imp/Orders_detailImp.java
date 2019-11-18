package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.gr21.dao.Orders_detailDAO;
import com.gr21.entity.Orders_detail;
import com.gr21.entity.Orders_detail.Orders_detail_id;
@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Orders_detailImp implements Orders_detailDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean AddOrderDetail(Orders_detail orders_detail) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Orders_detail_id id =  (Orders_detail_id) session.save(orders_detail);
		if(null != id ) {
			return true;
		}else {
		return false;}
	}
	public int total(int order_id) {
		Session session = sessionFactory.getCurrentSession();
		//int total = (Integer) session.createQuery("SELECT sum(quantity*price) FROM Orders_detail where orders_id='"+order_id+"'").getSingleResult();
		return 0;
	}
	public List<Orders_detail> getListOrders_detailbyId(String product_detail_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query= session.createQuery("from Orders_detail where product_detail_id = :product_detail_id");
		query.setParameter("product_detail_id", product_detail_id);
		List<Orders_detail> orders_detail  = query.getResultList();
				
		return orders_detail;
	}
	public Orders_detail getOrders_detail(String product_detail_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query= session.createQuery("from Orders_detail where product_detail_id = :product_detail_id");
		query.setParameter("product_detail_id", product_detail_id);
		Orders_detail orders_detail  = (Orders_detail) query.getSingleResult();
				
		return orders_detail;
	}
	
	public void delete(String product_detail_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.getOrders_detail(product_detail_id));
		
	}

}
