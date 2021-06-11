package com.simplilearn.sportyshoes.vo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="SHOE_DETAILS")
public class ShoeVO {

	@Id
	@Column(name="SHOE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int shoeId;

	@Column(name="SHOE_NAME")
	private String shoeName;
	
	@Column(name="SHOE_DETAIL")
	private String shoeDetail;
	
	@Column(name="SHOE_COUNT")
	private String shoeCount;
	
	@Column(name="SHOE_COST")
	private String shoeCost;
	
	@ManyToMany(mappedBy="shoes")
	private Set<PurchaseVO> purchases;

	public int getShoeId() {
		return shoeId;
	}

	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public String getShoeDetail() {
		return shoeDetail;
	}

	public void setShoeDetail(String shoeDetail) {
		this.shoeDetail = shoeDetail;
	}

	public String getShoeCount() {
		return shoeCount;
	}

	public void setShoeCount(String shoeCount) {
		this.shoeCount = shoeCount;
	}

	public String getShoeCost() {
		return shoeCost;
	}

	public void setShoeCost(String shoeCost) {
		this.shoeCost = shoeCost;
	}

	public Set<PurchaseVO> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<PurchaseVO> purchases) {
		this.purchases = purchases;
	}
}
