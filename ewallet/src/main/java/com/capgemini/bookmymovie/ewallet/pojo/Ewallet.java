package com.capgemini.bookmymovie.ewallet.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Ewallet {
	@Id
	private Integer profileId;
	private Double currentBalance;
	@OneToMany(mappedBy = "ewallet")
	@JsonManagedReference
	private List<Statement> statements;

	public Ewallet() {
	}

	public Ewallet(Double currentBalance, List<Statement> statements) {
		super();
		this.currentBalance = currentBalance;
		this.statements = statements;
	}

	public Ewallet(Integer walletId, Double currentBalance) {
		super();
		this.profileId = walletId;
		this.currentBalance = currentBalance;
	}

	public Ewallet(Integer walletId, Double currentBalance, List<Statement> statements) {
		super();
		this.profileId = walletId;
		this.currentBalance = currentBalance;
		this.statements = statements;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer walletId) {
		this.profileId = walletId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public String toString() {
		return "Ewallet [profileId=" + profileId + ", currentBalance=" + currentBalance + ", statements=" + statements
				+ "]";
	}

}
