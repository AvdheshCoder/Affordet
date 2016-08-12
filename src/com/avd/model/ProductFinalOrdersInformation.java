package com.avd.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * The persistent class for the product_final_orders_information database table.
 * 
 */
@Entity
@Table(name = "product_final_orders_information")
public class ProductFinalOrdersInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_id")
	private String orderId;

	private String address;

	private String name;
	private String cod;

	@Column(name = "COD_CHARGES")
	private Integer codCharges;

	@Column(name = "CUSTOMER_FINALIZE")
	private Integer customerFinalize;

	@Temporal(TemporalType.DATE)
	@Column(name = "delivered_date")
	private Date deliveredDate;

	@Column(name = "email_id")
	private String emailId;

	@Temporal(TemporalType.DATE)
	@Column(name = "expected_delivery_date")
	private Date expectedDeliveryDate;

	@Column(name = "GIFT_WRAP_CHARGES")
	private Integer giftWrapCharges;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "ODD_CHARGES")
	private Integer oddCharges;

	@Column(name = "ONE_DAY_DELIVERY")
	private String oneDayDelivery;

	@Column(name = "order_date")
	private Timestamp orderDate;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "pin_code")
	private Integer pinCode;

	@Column(name = "SELLER_FINALIZE")
	private Integer sellerFinalize;

	@Column(name = "STATUS_ID")
	private Integer statusId;

	@Column(name = "total_amount")
	private Integer totalAmount;

	@Column(name = "LOGIN_ID")
	private String loginId;

	@Column(name = "STATUS_DESCRIPTION")
	private String statusDescription;

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public ProductFinalOrdersInformation() {
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Integer getCodCharges() {
		return this.codCharges;
	}

	public void setCodCharges(Integer codCharges) {
		this.codCharges = codCharges;
	}

	public Integer getCustomerFinalize() {
		return this.customerFinalize;
	}

	public void setCustomerFinalize(Integer customerFinalize) {
		this.customerFinalize = customerFinalize;
	}

	public Date getDeliveredDate() {
		return this.deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getExpectedDeliveryDate() {
		return this.expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Integer getGiftWrapCharges() {
		return this.giftWrapCharges;
	}

	public void setGiftWrapCharges(Integer giftWrapCharges) {
		this.giftWrapCharges = giftWrapCharges;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getOddCharges() {
		return this.oddCharges;
	}

	public void setOddCharges(Integer oddCharges) {
		this.oddCharges = oddCharges;
	}

	public String getOneDayDelivery() {
		return this.oneDayDelivery;
	}

	public void setOneDayDelivery(String oneDayDelivery) {
		this.oneDayDelivery = oneDayDelivery;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Integer getSellerFinalize() {
		return this.sellerFinalize;
	}

	public void setSellerFinalize(Integer sellerFinalize) {
		this.sellerFinalize = sellerFinalize;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

}