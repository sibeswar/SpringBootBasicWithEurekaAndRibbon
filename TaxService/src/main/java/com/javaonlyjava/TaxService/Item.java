package com.javaonlyjava.TaxService;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	private Long id;

	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_description")
	private String itemDescription;
	@Column(name = "item_category")
	private String itemCategory;
	@Column(name = "item_tax_percentage")
	private BigDecimal taxPercentage;
	private int port;

	public Item() {

	}

	public Item(Long id, String itemName, String itemDescription, String itemCategory, BigDecimal taxPercentage) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemCategory = itemCategory;
		this.taxPercentage = taxPercentage;
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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
