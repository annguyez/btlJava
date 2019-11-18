package com.gr21.model;

public class CategoryStatisticDTO extends CategoryDTO {
	
	long totalShipped;
	long totalNotshipped;
	long totalCanceled;
	
	long totalShippedMoney;
	long totalNotshippedMoney;
	long totalCanceledMoney;
	public long getTotalShipped() {
		return totalShipped;
	}
	public void setTotalShipped(long totalShipped) {
		this.totalShipped = totalShipped;
	}
	public long getTotalNotshipped() {
		return totalNotshipped;
	}
	public void setTotalNotshipped(long totalNotshipped) {
		this.totalNotshipped = totalNotshipped;
	}
	public long getTotalCanceled() {
		return totalCanceled;
	}
	public void setTotalCanceled(long totalCanceled) {
		this.totalCanceled = totalCanceled;
	}
	public long getTotalShippedMoney() {
		return totalShippedMoney;
	}
	public void setTotalShippedMoney(long totalShippedMoney) {
		this.totalShippedMoney = totalShippedMoney;
	}
	public long getTotalNotshippedMoney() {
		return totalNotshippedMoney;
	}
	public void setTotalNotshippedMoney(long totalNotshippedMoney) {
		this.totalNotshippedMoney = totalNotshippedMoney;
	}
	public long getTotalCanceledMoney() {
		return totalCanceledMoney;
	}
	public void setTotalCanceledMoney(long totalCanceledMoney) {
		this.totalCanceledMoney = totalCanceledMoney;
	}
}
