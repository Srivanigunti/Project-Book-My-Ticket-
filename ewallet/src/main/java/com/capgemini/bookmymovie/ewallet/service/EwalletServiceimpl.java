package com.capgemini.bookmymovie.ewallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmymovie.ewallet.pojo.Ewallet;
import com.capgemini.bookmymovie.ewallet.pojo.Statement;
import com.capgemini.bookmymovie.ewallet.repository.EwalletRepository;
import com.capgemini.bookmymovie.ewallet.repository.StatementsRepository;

@Service
public class EwalletServiceimpl implements EwalletService {

	@Autowired
	EwalletRepository repo;

	@Autowired
	StatementsRepository statementrepo;

	public List<Ewallet> getWallets() {
		return repo.findAll();
	}

	public Ewallet addWallet(Ewallet wallet) {
		return repo.save(wallet);
	}

	public void update(Ewallet wallet, double amount, String transactionType) {

		repo.save(wallet);
		Statement statement = new Statement();
		statement.setAmount(amount);

		statement.setDateTime(LocalDateTime.now());

		statement.setTransactionRemarks("Transaction Completed");
		statement.setTransactionType(transactionType);
		statement.setEwallet(wallet);
		statementrepo.save(statement);
	}

	public Ewallet getById(int profileId) {
		Optional<Ewallet> wallet = repo.findById(profileId);
		if (wallet.isPresent()) {
			return wallet.get();
		} else
			return null;
	}

	public List<Statement> getStatementsById(int profileId) {
		Ewallet wallets = repo.findById(profileId).get();
		return wallets.getStatements();

	}

	public List<Statement> getStatements() {
		return statementrepo.findAll();
	}

	public void deleteByid(int id) {
		repo.deleteById(id);
	}

}
