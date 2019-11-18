package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.OrdersDAO;
import com.gr21.entity.Category;
import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;
@Repository
@Transactional
public class OrdersImp implements OrdersDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public Orders getOrders(int order_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Orders order = (Orders) session.createQuery("from Orders where orders_id = '"+order_id+"'").getSingleResult();
		
		
		return order;
	}

	public boolean searchOrders(int order_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			Orders order = (Orders) session.createQuery("from Orders where orders_id = '"+order_id+"'").getSingleResult();
			if(order!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		

	}
	
	public List<Orders> getListOrders() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " from Orders";
		Query query = session.createQuery(hql);
		List<Orders> list = query.getResultList();
		return list;
	}

	public String getOrdersName(int odrers_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select c.oders_name from Oders c where orders_id = :orders_id";
		Query query = session.createQuery(hql);
		String orders_name = (String) query.getSingleResult();
		return orders_name;
	}

	public List<String> getListOrdersName() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.orders_name from Orders c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Orders order) {
		Session session = sessionFactory.getCurrentSession();	
		session.save(order);
	}

	public void delete(int orders_id) {
		Session session = sessionFactory.getCurrentSession();	
		
		session.delete(this.getOrders(orders_id));	
	}

	public void update(Orders order) {
		Session session = sessionFactory.getCurrentSession();	
		session.update(order);
		
	}

	public int addOrder(Orders ord) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(ord);
		if(0 < id) {
			return id;
		}else {
			return 0;
		}
	}

	public List<Orders> getListOrders(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " from Orders";
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Orders> list = query.getResultList();
		return list;
	}
	public Long countOder() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(orders_id) from Orders";
		Query query = session.createQuery(hql);
		return (Long)query.getSingleResult();
	}
	public List<Orders> getListOrdersByStatus() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " FROM Orders E WHERE E.orders_status = 0";
		Query query = session.createQuery(hql);
		List<Orders> list = query.getResultList();
		return list;
	}
	
	public List<Orders> getListOrdersByStatus1() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " FROM Orders E WHERE E.orders_status = 1";
		Query query = session.createQuery(hql);
		List<Orders> list = query.getResultList();
		return list;
	}
	public List<Orders> getListOrdersByStatus2() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = " FROM Orders E WHERE E.orders_status = 2";
		Query query = session.createQuery(hql);
		List<Orders> list = query.getResultList();
		return list;
	}
	
	public List<Orders_detail> getOrders_detail(int orders_id){
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.orders_detail from Orders c where c.orders_id="+orders_id;
		Query query = session.createQuery(hql);
		List<Orders_detail> list = query.getResultList();
		return list;
	}
}
