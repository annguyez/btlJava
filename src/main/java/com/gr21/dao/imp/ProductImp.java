package com.gr21.dao.imp;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.gr21.dao.ProductDAO;
import com.gr21.entity.Category;
import com.gr21.entity.Color;
import com.gr21.entity.Product;
import com.gr21.entity.Size;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductImp implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, product_id);
	}
	
	public List<Product> getListProduct() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.getResultList();
		return list;
	}
	public List<Product> getListNewest(int category_id,int startPosition,int maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Product ";
		if(category_id!=0) {
			hql+=" where p.category.category_id = "+category_id+" ";
		}
			hql+= " order by product_id desc";
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Product> list = query.getResultList();
		return list;
	}
	public String getProductName(int product_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select product_name from Product  where product_id = "+product_id;
		Query query = session.createQuery(hql);
		String product_name = (String) query.getSingleResult();
		return product_name;
	}

	public List<String> getListCategoryName() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select c.product_name from Product c";
		Query query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}

	public boolean create(Product product) {
		// TODO Auto-generated method stub
		if(this.isExisted(product.getProduct_name())) return false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int product_id) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.delete(this.getProduct(product_id));
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		String oldname = this.getProductName(product.getProduct_id());
		if(product.getProduct_name().compareTo(oldname)!=0) {
			if(this.isExisted(product.getProduct_name())) return false;
		}
			Session session = sessionFactory.getCurrentSession();
			session.update(product);
			return true;
		
	}

	public Product getProductDetailById(int product_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql  = "from Product where product_id="+product_id;
		Product pr = (Product) session.createQuery(hql).getSingleResult();
		return pr;
	}

	public List<Color> getColorbySizeId(int size_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql  = "from Product_detail where size_id="+size_id;
		List<Color> color = (List<Color>) session.createQuery(hql).getResultList();
		return (List<Color>) color;
	}

	
	public int getLastest() {
		
		Session session = sessionFactory.getCurrentSession();
		String sql  = "SELECT auto_increment AS NEXT_ID " + 
				"FROM   information_schema.`tables` " + 
				"WHERE  table_name = 'product'  ";
		session.createNativeQuery("SET @@SESSION.information_schema_stats_expiry = 0").executeUpdate();
		BigInteger product_id = (BigInteger) session.createNativeQuery(sql).getSingleResult();
		return product_id.intValue();
	}

	public int getMaxDiscount(int product_id, String date) {
		Session session = sessionFactory.getCurrentSession();		
		String sql  ="SELECT max(s.discount) FROM Product p inner join p.sales s "
		+ "where s.sale_end >= :date and s.sale_start <= :date and p.product_id= :product_id";
		Query query = session.createQuery(sql);
		
		query.setParameter("product_id", product_id);
		query.setParameter("date", date);
		
		return (Integer) query.getSingleResult();
	}

	public List<Object[]> getProducts(int sale_id) {
		Session session = sessionFactory.getCurrentSession();		
		String sql  ="SELECT p.product_id,p.product_name FROM Product p inner join p.sales s "
		+ "where s.sale_id= :sale_id";
		Query query = session.createQuery(sql);
		query.setParameter("sale_id", sale_id);
		
		return query.getResultList();
	}

	public List<Product> getListProduct(int startPosition,int maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Product";
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Product> list = query.getResultList();
		return list;
	}

	public List<Product> getListProduct(int category_id,int startPosition,int maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="from Product where category.category_id=:category_id";
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		query.setParameter("category_id", category_id);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public Long getCountProduct() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(product_id) from Product";
		Query query = session.createQuery(hql);
		return (Long)query.getSingleResult();
	}
	
	
	public Long getCountProduct(int category_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(product_id) from Product ";
		if(category_id!=0) {
			hql+=" where category.category_id=:category_id";
		}
		
		Query query = session.createQuery(hql);
		if(category_id!=0) {
			query.setParameter("category_id", category_id);
		}
		return (Long)query.getSingleResult();
	}
	public List<Product> getTopProduct(int startPosittion, int maxResult){
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(product_id) from Product where category.category_id=:category_id";
		Query query = session.createQuery(hql).setFirstResult(startPosittion).setMaxResults(maxResult);
		
		return query.getResultList();
	}
	
	public boolean isExisted(String product_name) {
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		String hql ="select product_id from Product where product_name='"+product_name+"'";
		Query query = session.createQuery(hql);
		if(!query.getResultList().isEmpty()) {
			flag=true;
			return flag;
		}
		return flag;
	}

	public List<Product> getProductASC(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM Product p where category_id="+id+" ORDER BY cast(p.price as integer) ASC";
		Query query = session.createQuery(hql);
		List<Product> list = query.getResultList();
		return list;
		
	}

	public List<Product> getProductByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Product p where upper(product_name) like '%"+name.toUpperCase()+"%'  group by product_id ORDER BY (p.price) ASC";
		Query query = session.createQuery(hql);
		List<Product> result = query.getResultList();
		return result;
	}
	
	public  List<Product> getBestSeller(int category_id,int startPosition,int maxResult){
		Session session = sessionFactory.getCurrentSession();
		String hql ="select p from Product p ";
			hql+= " inner join p.products_detail pd on p.product_id = pd.product.product_id";
			hql += " left join pd.orders_detail od on pd.product_detail_id = od.orders_detail_id.product_detail_id";
		if(category_id!=0) {
			hql+=" where p.category.category_id = "+category_id+" ";
		}
		hql+= " group by p.product_id ";
		hql +=" order by sum(od.quantity) desc";
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public  List<Product> multiSearch(int category_id,int minPrice,int maxPrice,String name,int orderby,int startPosition,int maxResult){
		Session session = sessionFactory.getCurrentSession();
		String hql ="select p from Product p ";
		if(orderby==1) {
			hql+= " inner join p.products_detail pd on p.product_id = pd.product.product_id";
			hql += " left join pd.orders_detail od on pd.product_detail_id = od.orders_detail_id.product_detail_id";
		}
		if(category_id!=0) {
			hql+=" where p.category.category_id = "+category_id+" ";
			if(minPrice>0) {
				hql+=" and cast(p.price as integer) >= "+minPrice+" ";
			}
			if(maxPrice>0) {
				hql+=" and cast(p.price as integer) <= "+maxPrice+" ";
			}
			if(name!="") {
				hql+=" and upper(product_name) like '%"+name.toUpperCase()+"%' "	;
			}
			
		}else {
			if(minPrice>0||maxPrice>0||name!="") {
				hql+=" where ";
			}
			if(minPrice>0) {
				hql+="  cast(p.price as integer) >= "+minPrice+" ";
			}else {
				if(maxPrice>0) {
					hql+=" cast(p.price as integer) <= "+maxPrice+" ";
					
				}else {
					if(name!="") {
						hql+=" upper(product_name) like '%"+name.toUpperCase()+"%' "	;
					}
				}
				if(name!="") {
					hql+=" and upper(product_name) like '%"+name.toUpperCase()+"%' "	;
				}
			}
			if(maxPrice>0) {
				hql+=" and cast(p.price as integer) <= "+maxPrice+" ";
			}
			if(name!="") {
				hql+=" and upper(product_name) like '%"+name.toUpperCase()+"%' "	;
			}
			
			
			
		}
		
		hql+= " group by p.product_id ";
		switch(orderby){
			case 1:	hql +=" order by sum(od.quantity) desc";break;
			case 2: hql +=" order by p.product_id desc";break;
			case 3: hql +=" order by cast(p.price as integer) ASC";break;
			case 4: hql +=" order by cast(p.price as integer) DESC";break;
			default: hql +=" order by p.product_id desc";break;
		}
		
		Query query = session.createQuery(hql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Product> list = query.getResultList();
		return list;
	}
	
	
	
	
	public  int counMultiSearch(int category_id,int minPrice,int maxPrice,String name,int orderby){
		Session session = sessionFactory.getCurrentSession();
		String hql ="select p.product_id as product_id from Product p ";
		if(orderby==1) {
			hql+= " inner join p.products_detail pd on p.product_id = pd.product.product_id";
			hql += " left join pd.orders_detail od on pd.product_detail_id = od.orders_detail_id.product_detail_id";
		}
		if(category_id!=0) {
			hql+=" where p.category.category_id = "+category_id+" ";
			if(minPrice>0) {
				hql+=" and cast(p.price as integer) >= "+minPrice+" ";
			}
			if(maxPrice>0) {
				hql+=" and cast(p.price as integer) <= "+maxPrice+" ";
			}
			if(name!="") {
				hql+=" and upper(product_name) like '%"+name.toUpperCase()+"%' "	;
			}
			
		}else {
			if(minPrice>0||maxPrice>0||name!="") {
				hql+=" where ";
			}
			if(minPrice>0) {
				hql+="  cast(p.price as integer) >= "+minPrice+" ";
			}else {
				if(maxPrice>0) {
					hql+=" cast(p.price as integer) <= "+maxPrice+" ";
					
				}else {
					if(name!="") {
						hql+=" upper(product_name) like '%"+name.toUpperCase()+"%' "	;
					}
				}
				if(name!="") {
					hql+=" and upper(product_name) like '%"+name.toUpperCase()+"%' "	;
				}
			}
			if(maxPrice>0) {
				hql+=" and cast(p.price as integer) <= "+maxPrice+" ";
			}
			if(name!="") {
				hql+=" and upper(product_name) like '%"+name.toUpperCase()+"%' "	;
			}
		}
		hql+= " group by p.product_id ";

		
		Query query = session.createQuery(hql);
		int count =  query.getResultList().size();
		return count;
	}
	
	
	
	
}
