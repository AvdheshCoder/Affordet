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

	@Column(name = "Address")
	private String address;

	@Column(name = "NAME")
	private String name;

	@Column(name = "COD")
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

	@Column(name = "RETURN_DAYS")
	private String returnDays;

	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "CREATED_AT")
	private String createdAt;

	@Column(name = "TOTAL_AMOUNT_RECEIVED")
	private String totalAmountRecieved;

	@Column(name = "REJECTED_BY")
	private String rejectedBy;

	@Column(name = "REJECTED_REASON")
	private String rejectedReason;


	@Column(name = "CONFIRMED_ON")
	private Date confirmedOn;

	@Column(name = "DISPATCHED_ON")
	private Date dispatchedOn;

	@Column(name = "COMPLETED_ON")
	private Date completedOn;

	@Column(name = "REJECTED_ON")
	private Date rejecedOn;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Integer getCodCharges() {
		return codCharges;
	}

	public void setCodCharges(Integer codCharges) {
		this.codCharges = codCharges;
	}

	public Integer getCustomerFinalize() {
		return customerFinalize;
	}

	public void setCustomerFinalize(Integer customerFinalize) {
		this.customerFinalize = customerFinalize;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Integer getGiftWrapCharges() {
		return giftWrapCharges;
	}

	public void setGiftWrapCharges(Integer giftWrapCharges) {
		this.giftWrapCharges = giftWrapCharges;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getOddCharges() {
		return oddCharges;
	}

	public void setOddCharges(Integer oddCharges) {
		this.oddCharges = oddCharges;
	}

	public String getOneDayDelivery() {
		return oneDayDelivery;
	}

	public void setOneDayDelivery(String oneDayDelivery) {
		this.oneDayDelivery = oneDayDelivery;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Integer getSellerFinalize() {
		return sellerFinalize;
	}

	public void setSellerFinalize(Integer sellerFinalize) {
		this.sellerFinalize = sellerFinalize;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getReturnDays() {
		return returnDays;
	}

	public void setReturnDays(String returnDays) {
		this.returnDays = returnDays;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTotalAmountRecieved() {
		return totalAmountRecieved;
	}

	public void setTotalAmountRecieved(String totalAmountRecieved) {
		this.totalAmountRecieved = totalAmountRecieved;
	}

	public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	

	public Date getConfirmedOn() {
		return confirmedOn;
	}

	public void setConfirmedOn(Date confirmedOn) {
		this.confirmedOn = confirmedOn;
	}

	public Date getDispatchedOn() {
		return dispatchedOn;
	}

	public void setDispatchedOn(Date dispatchedOn) {
		this.dispatchedOn = dispatchedOn;
	}

	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	public Date getRejecedOn() {
		return rejecedOn;
	}

	public void setRejecedOn(Date rejecedOn) {
		this.rejecedOn = rejecedOn;
	}

}