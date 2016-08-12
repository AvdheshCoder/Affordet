package com.avd.service.vo;

import java.util.List;

import com.avd.model.ProductFinalOrdersInformation;
import com.avd.model.TblProductInformation;
import com.avd.service.vo.NavigationInfo;

public class PagedOrdersView {

	private NavigationInfo navInfo = new NavigationInfo();

	private List<ProductFinalOrdersInformation> ordersInfo;

	public NavigationInfo getNavInfo() {
		return navInfo;
	}

	public void setNavInfo(NavigationInfo navInfo) {
		this.navInfo = navInfo;
	}

	public List<ProductFinalOrdersInformation> getordersInfo() {
		return ordersInfo;
	}

	public void setOrderInfo(List<ProductFinalOrdersInformation> ordersInfo) {
		this.ordersInfo = ordersInfo;
	}

	public ProductFinalOrdersInformation getproductObject(int i) {
		return (ProductFinalOrdersInformation) ordersInfo.get(i);
	}

	public void setOrderObject(int i, ProductFinalOrdersInformation ordersInfo) {
		this.ordersInfo.add(i, ordersInfo);
	}
}
