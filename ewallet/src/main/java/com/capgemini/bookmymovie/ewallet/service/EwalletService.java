package com.capgemini.bookmymovie.ewallet.service;

import java.util.List;

import com.capgemini.bookmymovie.ewallet.pojo.Ewallet;
import com.capgemini.bookmymovie.ewallet.pojo.Statement;

public interface EwalletService {

	public List<Ewallet> getWallets();

	Ewallet addWallet(Ewallet wallet);

	public void update(Ewallet wallet, double amount, String transactionType);

	public Ewallet getById(int walletId);

	public List<Statement> getStatementsById(int walletId);

	public List<Statement> getStatements();

	public void deleteByid(int id);
}
