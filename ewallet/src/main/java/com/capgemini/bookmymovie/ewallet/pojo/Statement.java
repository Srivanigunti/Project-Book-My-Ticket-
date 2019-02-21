package com.capgemini.bookmymovie.ewallet.pojo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Statement")
public class Statement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profileId")
	@JsonBackReference
	private Ewallet ewallet;
	private String transactionType;
	private Double amount;
	private LocalDateTime dateTime;
    private String transactionRemarks;

	public Statement() {
		// TODO Auto-generated constructor stub
	}

	public Statement(Integer transactionId, Ewallet ewallet, String transactionType, Double amount,
			LocalDateTime dateTime, String transactionRemarks) {
		super();
		this.transactionId = transactionId;
		this.ewallet = ewallet;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.transactionRemarks = transactionRemarks;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Ewallet getEwallet() {
		return ewallet;
	}

	public void setEwallet(Ewallet ewallet) {
		this.ewallet = ewallet;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	@Override
	public String toString() {
		return "Statement [transactionId=" + transactionId + ", ewallet=" + ewallet + ", transactionType="
				+ transactionType + ", amount=" + amount + ", dateTime=" + dateTime + ", transactionRemarks="
				+ transactionRemarks + "]";
	}

}
