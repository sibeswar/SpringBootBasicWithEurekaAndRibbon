package com.javaonlyjava.paymentservice;

import java.math.BigDecimal;

public class PaymentServiceBean {
	  private Long id;
	  private String itemName;
	  private BigDecimal quantity;
	  private BigDecimal itemPrice;
	  private BigDecimal itemTotalPrice;
	  private BigDecimal taxPercentage;
	  private BigDecimal itemTotalPriceWithTax;
	  private int port;
	  
	  public PaymentServiceBean() {
		  
	  }
	  
	public PaymentServiceBean(Long id, String itemName, BigDecimal quantity, BigDecimal itemPrice,
			BigDecimal itemTotalPrice, BigDecimal taxPercentage, BigDecimal itemTotalPriceWithTax, int port) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
		this.itemTotalPrice = itemTotalPrice;
		this.taxPercentage = taxPercentage;
		this.itemTotalPriceWithTax = itemTotalPriceWithTax;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public BigDecimal getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(BigDecimal itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public BigDecimal getItemTotalPriceWithTax() {
		return itemTotalPriceWithTax;
	}

	public void setItemTotalPriceWithTax(BigDecimal itemTotalPriceWithTax) {
		this.itemTotalPriceWithTax = itemTotalPriceWithTax;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
