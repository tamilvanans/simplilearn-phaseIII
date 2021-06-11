package com.simplilearn.sportyshoes.vo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="PURCHASE_DETAILS")
public class PurchaseVO {
	
	@Id
	@Column(name="PURCHASE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@ManyToMany
	@JoinTable(name="SHOE_PURCHASES",
			joinColumns = @JoinColumn(name="PURCHASE_ID",referencedColumnName = "PURCHASE_ID"),
			inverseJoinColumns = @JoinColumn(name="SHOE_ID",referencedColumnName = "SHOE_ID"))
	private Set<ShoeVO> shoes;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserVO user;
	
	@Column(name="PURCHASE_AMOUNT")
	private int purchaseAmount;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@PrePersist
	private void createDate() {
		creationDate =  new Date();
	}
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_TIME")
	private Date updationDate;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Set<ShoeVO> getShoes() {
		return shoes;
	}

	public void setShoes(Set<ShoeVO> shoes) {
		this.shoes = shoes;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}
}

