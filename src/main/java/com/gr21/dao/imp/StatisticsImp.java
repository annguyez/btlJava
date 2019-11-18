package com.gr21.dao.imp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gr21.dao.StatisticsDAO;
import com.gr21.model.ProductDTO;
import com.gr21.model.Product_detailDTO;


@Transactional
@Repository
public class StatisticsImp implements StatisticsDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public long countTotalProduct(int category_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="select count(p.product_id) from Product p";
		if(category_id!=0) {
			hql+=" where p.category.category_id = " + category_id;
		}
		return (Long) session.createQuery(hql).getSingleResult();
	}
	

	public long countTotalProductShipped(int category_id) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="select count(*) from( "
				+ " select p.product_id  from product p "
				+ " left join category c on p.category_id =  c.category_id "
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id  "
				+ " where o.orders_status = 1 ";
		if(category_id!=0) {
			sql+=" and c.category_id = "+category_id;
		}
		sql	+= " group by p.product_id) as Shipped";
		BigInteger count =  (BigInteger) session.createNativeQuery(sql).getSingleResult();
		return count.longValue();
	}

	
	public long countTotalProductByMonth(String Month,int category_id) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="select count(*) from( "
				+ " select p.product_id  from product p "
				+ " left join category c on p.category_id =  c.category_id "
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id  "
				+ " where o.orders_date like '"+Month+"%' ";
		if(category_id!=0) {
			sql+=" and c.category_id = "+category_id;
		}
		sql	+= " group by p.product_id) as Shipped";
		BigInteger count =  (BigInteger) session.createNativeQuery(sql).getSingleResult();
		return count.longValue();
	}
	
	
	
	
	public long countTotalProductShippedByMonth(String Month,int category_id) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="select count(*) from( "
				+ " select p.product_id  from product p "
				+ " left join category c on p.category_id =  c.category_id "
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id left join orders o on od.orders_id = o.orders_id  "
				+ " where o.orders_status = 1 and o.orders_date like '"+Month+"%' ";
		if(category_id!=0) {
			sql+=" and c.category_id = "+category_id;
		}
		sql	+= " group by p.product_id) as Shipped";
		BigInteger count =  (BigInteger) session.createNativeQuery(sql).getSingleResult();
		return count.longValue();
	}
	

	
	public List<ProductDTO> getProducts(int category_id,String orderby,int startPosition,int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		String sql =" select p.product_id,p.product_name,c.category_name,sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id "
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id " 
				+ " left join orders o on od.orders_id = o.orders_id";
		if(category_id!=0) {
			sql+=" where c.category_id = "+category_id;
		}
		sql+= " group by p.product_id order by " +orderby+"  p.product_id asc";
		Query query = session.createNativeQuery(sql).setFirstResult(startPosition).setMaxResults(maxResult);;
		List<Object[]> products =query.getResultList();
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Object[] pro:products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_id((Integer)pro[0]);
			productDTO.setProduct_name((String)pro[1]);
			productDTO.setCategory_name((String)pro[2]);
			try {
				productDTO.setTotal(((BigDecimal )pro[3]).intValue());
				productDTO.setTotal_money(((Double )pro[4]).longValue());
			} catch (Exception e) {
				productDTO.setTotal(0);
				productDTO.setTotal_money(0);
			}
			
			list.add(productDTO);
		}
		return list;
	}

	public List<ProductDTO> getProductsShipped(int category_id,String orderby, int startPosition, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="select p.product_id,p.product_name,c.category_name,sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id "
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id " 
				+ " left join orders o on od.orders_id = o.orders_id"
				+ " where o.orders_status = 1 ";
		if(category_id!=0) {
			sql+=" and c.category_id = "+category_id;
		}
		sql+= " group by p.product_id order by " +orderby+" p.product_id asc";
		Query query = session.createNativeQuery(sql).setFirstResult(startPosition).setMaxResults(maxResult);;
		List<Object[]> products =query.getResultList();
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Object[] pro:products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_id((Integer)pro[0]);
			productDTO.setProduct_name((String)pro[1]);
			productDTO.setCategory_name((String)pro[2]);
			try {
				productDTO.setTotal(((BigDecimal )pro[3]).intValue());
				productDTO.setTotal_money(((Double )pro[4]).longValue());
			} catch (Exception e) {
				productDTO.setTotal(0);
				productDTO.setTotal_money(0);
			}
			
			list.add(productDTO);
		}
		return list;
	}

	public List<ProductDTO> getProductsByMonth(String Month,int category_id, String orderby, int startPosition, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="select p.product_id,p.product_name,c.category_name,sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id "
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id "
				+ " where o.orders_date like '"+Month+"%' ";
		if(category_id!=0) {
			sql+=" and c.category_id = "+category_id;
		}
		sql+= " group by p.product_id order by " +orderby+" p.product_id asc";
		Query query = session.createNativeQuery(sql).setFirstResult(startPosition).setMaxResults(maxResult);;
		List<Object[]> products =query.getResultList();
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Object[] pro:products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_id((Integer)pro[0]);
			productDTO.setProduct_name((String)pro[1]);
			productDTO.setCategory_name((String)pro[2]);
			try {
				productDTO.setTotal(((BigDecimal )pro[3]).intValue());
				productDTO.setTotal_money(((Double )pro[4]).longValue());
			} catch (Exception e) {
				productDTO.setTotal(0);
				productDTO.setTotal_money(0);
			}
			
			list.add(productDTO);
		}
		return list;
	}

	public List<ProductDTO> getProductsShippedByMonth(String Month, int category_id,String orderby, int startPosition, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		String sql =" select p.product_id,p.product_name,c.category_name,sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id"
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id "
				+ " where o.orders_status = 1 and o.orders_date like '"+Month+"%' ";
		if(category_id!=0) {
			sql+=" and c.category_id = "+category_id;
		}
		sql+= " group by p.product_id order by " +orderby+" p.product_id asc";
		Query query = session.createNativeQuery(sql).setFirstResult(startPosition).setMaxResults(maxResult);
		List<Object[]> products =query.getResultList();
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Object[] pro:products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_id((Integer)pro[0]);
			productDTO.setProduct_name((String)pro[1]);
			productDTO.setCategory_name((String)pro[2]);
			try {
				productDTO.setTotal(((BigDecimal )pro[3]).intValue());
				productDTO.setTotal_money(((Double )pro[4]).longValue());
			} catch (Exception e) {
				productDTO.setTotal(0);
				productDTO.setTotal_money(0);
			}
			
			list.add(productDTO);
		}
		return list;
	}
	
	
	public ProductDTO getSingleProduct(int product_id,String month,int status) {
		Session session = sessionFactory.getCurrentSession();
		String sql =" select p.product_id,p.product_name,c.category_name,sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id"
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id "
				+ " where p.product_id = "+product_id
				+ " and o.orders_status =  "+status;
		if(month!="") {
			sql +=" and o.orders_date like '"+month+"%' ";
		}
				
		sql += " group by p.product_id ";
		ProductDTO productDTO = new ProductDTO();
		Query query = session.createNativeQuery(sql);
		try {
			Object[] pro =(Object[]) query.getSingleResult();			
			productDTO.setProduct_id((Integer)pro[0]);
			productDTO.setProduct_name((String)pro[1]);
			productDTO.setCategory_name((String)pro[2]);
			try {
				productDTO.setTotal(((BigDecimal )pro[3]).intValue());
				productDTO.setTotal_money(((Double )pro[4]).longValue());
			} catch (Exception e) {
				productDTO.setTotal(0);
				productDTO.setTotal_money(0);
			}
		}
		catch(Exception e) {
			productDTO.setTotal(0);
			productDTO.setTotal_money(0);
			return productDTO;
		}
		return productDTO;
	}
	
	public Product_detailDTO getSingleProductDetail (String product_detail_id,String month,int status) {
		Session session = sessionFactory.getCurrentSession();
		String sql ="select sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id"
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id "
				+ " where pd.product_detail_id = '"+product_detail_id+"'"
				+ " and o.orders_status =  "+status;
	
		if(month!="") {
			sql +=" and o.orders_date like '"+month+"%' ";
		}
				
		sql += " group by p.product_id,pd.product_detail_id ";
		Query query = session.createNativeQuery(sql);
		Product_detailDTO detailDTO = new Product_detailDTO();
		detailDTO.setProduct_detail_id(product_detail_id);
		try {
			Object[] detail =(Object[]) query.getSingleResult();			
		
			try {
				detailDTO.setTotal(((BigDecimal )detail[0]).intValue());
				detailDTO.setTotal_money(((Double )detail[1]).longValue());
			} catch (Exception e) {
				detailDTO.setTotal(0);
				detailDTO.setTotal_money(0);
			}
		}catch(Exception e) {
			detailDTO.setTotal(0);
			detailDTO.setTotal_money(0);
		}
		

		
		return detailDTO;
	}
	
	
	public long[] getStatisticsleCategory(int category_id,String month,int status) {
		long[] total = new long[2];
		Session session = sessionFactory.getCurrentSession();
		String sql =" select p.product_id,p.product_name,c.category_name,sum(od.quantity) as 'total_quantity',sum(od.price*od.quantity) as 'total_money' "
				+ " from product p "
				+ " left join category c on p.category_id =  c.category_id"
				+ " left join product_detail pd on p.product_id =pd.product_id "
				+ " left join orders_detail od on pd.product_detail_id =od.product_detail_id "
				+ " left join orders o on od.orders_id = o.orders_id "
				+ " where c.category_id = "+category_id
				+ " and o.orders_status =  "+status;
		if(month!="") {
			sql +=" and o.orders_date like '"+month+"%' ";
		}		
		sql += " group by c.category_id ";
		
		Query query = session.createNativeQuery(sql);
		try {
			Object[] pro =(Object[]) query.getSingleResult();			
			try {
				total[0]=((BigDecimal )pro[3]).intValue();
				total[1]=((Double )pro[4]).longValue();
			} catch (Exception e) {
				total[0]=0;
				total[1]=0;
			}
		}
		catch(Exception e) {
			total[0]=0;
			total[1]=0;
		}
		return total;
	}
}
