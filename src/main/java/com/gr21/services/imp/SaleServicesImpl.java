package com.gr21.services.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.SaleDAO;
import com.gr21.entity.Product;
import com.gr21.entity.Sale;
import com.gr21.services.SaleServices;

import javassist.expr.NewArray;
@Service
public class SaleServicesImpl implements SaleServices {

	@Autowired
	SaleDAO saleDAO;
	public List<Sale> getListSale() {
		// TODO Auto-generated method stub
		return saleDAO.getListSale();
	}
	public void create(Sale sale) {
		saleDAO.create(sale);
		
	}
	public Sale getSale(int sale_id) {
		// TODO Auto-generated method stub
		return saleDAO.getSale(sale_id);
	}
	public void update(Sale sale) {
		saleDAO.update(sale);
		
	}
	public List<Sale> getListSale(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		return saleDAO.getListSale(startPosition, maxResult);
	}
	public long countTotalSale() {
		// TODO Auto-generated method stub
		return saleDAO.countTotalSale();
	}
	public long countSale(int command,int product_id){
		String cmsql="";
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String day="'"+sdf.format(today)+"'";
		switch (command) {
		case 1:
			cmsql=" where s.sale_start < "+day+" and s.sale_end >"+day+" ";
			break;
		case 2:
			cmsql=" where s.sale_end <"+day+" ";
			break;
		case 3:
			cmsql=" where s.sale_start >"+day+" ";
			break;
		default:
			cmsql="";
			break;
		}
		return saleDAO.countSale(cmsql,product_id);
	}
	public List<Sale> getListSale(int command,int product_id,int startPosition,int maxResult){
		String cmsql="";
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String day="'"+sdf.format(today)+"'";
		switch (command) {
		case 1:
			cmsql=" where s.sale_start < "+day+" and s.sale_end >"+day+" ";
			break;
		case 2:
			cmsql=" where s.sale_end <"+day+" ";
			break;
		case 3:
			cmsql=" where s.sale_start >"+day+" ";
			break;
		default:
			cmsql="";
			break;
		}
		try {
			return saleDAO.getListSale(cmsql,product_id,startPosition,maxResult);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public void delete(int sale_id) {
		saleDAO.delete(sale_id);
	}
	
}
