package com.gr21.dao.imp;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.Product_detailDAO;
import com.gr21.entity.Category;
import com.gr21.entity.Color;
import com.gr21.entity.Product_detail;
import com.gr21.entity.Size;
import com.gr21.model.SizeDTO;
@Repository
@Transactional
public class Product_detailImp implements Product_detailDAO {

	@Autowired
	SessionFactory sessionFactory;
	public Product_detail getProduct_detail(String product_detail_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product_detail.class, product_detail_id);
		
	}

	public List<Product_detail> getListProduct_detail() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Product_detail";
		Query query = session.createQuery(hql);
		List<Product_detail> list = query.getResultList();
		return list;

	}

	public String getProduct_detailName(String product_detail_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.product_name from Product_detail c where product_detail_id = '"+product_detail_id+"'";
		Query query = session.createQuery(hql);
		String product_name = (String) query.getSingleResult();
		return product_name;
	}

	public List<String> getListProduct_detailName() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.product_name from Product_detail c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public void create(Product_detail product_detail) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.save(product_detail);
	}

	public void delete(String product_detail_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.delete(this.getProduct_detail(product_detail_id));	
	}

	public void update(Product_detail product_detail) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(product_detail);
		
	}

	public List<Color> getColor(int product_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select p.color from Product_detail p where p.product.product_id="+product_id+" group by p.color.color_id";
		Query query = session.createQuery(hql);
		List<Color> list = query.getResultList();
		return list;
	}

	public List<Size> getSizeByColor(int color_id, int product_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select p.size from Product_detail p where p.product.product_id="+product_id+" and p.color.color_id = "+color_id+""
				+ " group by p.size.size_id";
		Query query = session.createQuery(hql);
		List<Size> list = query.getResultList();
		return list;
	}

	public List<SizeDTO> getListSize(int product_id, int color_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select  new "+SizeDTO.class.getName()+"( p.size.size_id,p.size.size) from Product_detail p where p.color.color_id=:color_id"
				+ " and p.product.product_id=:product_id";
		Query query = session.createQuery(hql);
		query.setParameter("product_id", product_id);
		query.setParameter("color_id", color_id);
		List<SizeDTO> list = query.getResultList();
		return list;
	}
	
	public List<Product_detail> getProduct_detailsByProduct_id(int product_id){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product_detail p where p.product.product_id = "+product_id+"order by p.product_detail_id";
		Query query = session.createQuery(hql);
		List<Product_detail> list = query.getResultList();
		return list;
	}
	public Product_detail getProduct_detailByOr(String product_detail_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query= session.createQuery("from Product_detail where product_detail_id = :product_detail_id");
		query.setParameter("product_detail_id", product_detail_id);
		Product_detail product_detail  =(Product_detail) query.getSingleResult();
				
		return product_detail;
	}
	public List <Product_detail> getListProduct_detailByOr(String product_detail_id) {
		Session session = sessionFactory.getCurrentSession();
		List <Product_detail> product_detail=  session.createQuery("from Product_detail where product_detail_id = '"+product_detail_id+"'").getResultList();
		return product_detail;
	}
}
