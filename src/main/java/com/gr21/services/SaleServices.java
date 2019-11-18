package com.gr21.services;

import java.util.List;


import com.gr21.entity.Sale;

public interface SaleServices {
	public Sale getSale(int sale_id);
	public List<Sale> getListSale();
	public void create(Sale sale );
	public void update(Sale sale);
	public List<Sale> getListSale(int startPosition,int maxResult);
	public long countTotalSale();
	public long countSale(int command,int product_id);
	public List<Sale> getListSale(int command,int product_id,int startPosition,int maxResult);
	public void delete(int sale_id);
}
