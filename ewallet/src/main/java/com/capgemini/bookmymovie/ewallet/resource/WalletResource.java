package com.capgemini.bookmymovie.ewallet.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmymovie.ewallet.pojo.Ewallet;
import com.capgemini.bookmymovie.ewallet.pojo.Statement;
import com.capgemini.bookmymovie.ewallet.service.EwalletService;

@RestController
@RequestMapping("/wallets")
public class WalletResource {

	private final static String Deposit = "Money Deposit";
	private final static String Withdraw = "Money Withdraw";

	@Autowired
	EwalletService service;
	
	@PostMapping("/{profileId}")
    public HttpStatus addNewWallet(@PathVariable Integer profileId) {
        Ewallet wallet = new Ewallet();
        wallet.setProfileId(profileId);
        wallet.setCurrentBalance(2000.0);
        service.addWallet(wallet);
        return HttpStatus.CREATED;
    }
	@GetMapping
	// @JsonDeserialize
	public ResponseEntity<List<Ewallet>> getAllWallet() {
		List<Ewallet> wallets = service.getWallets();
		if (wallets.isEmpty())
			return new ResponseEntity<List<Ewallet>>(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<List<Ewallet>>(wallets, HttpStatus.OK);
	}

	@GetMapping("/{profileId}")
	public ResponseEntity<Ewallet> getById(@PathVariable int profileId) {
		Ewallet wallet = service.getById(profileId);
		if (wallet.equals(null))
			return new ResponseEntity<Ewallet>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Ewallet>(wallet, HttpStatus.OK);
	}

	@PutMapping("/{profileId}")
	public ResponseEntity<Ewallet> AddMoney(@PathVariable int profileId, @RequestParam("currentBalance") double amount) {
		Ewallet wallet = service.getById(profileId);
		if (amount > 0) {
			wallet.setCurrentBalance(wallet.getCurrentBalance() + amount);
			service.update(wallet, amount, Deposit);
			return new ResponseEntity<>(wallet,HttpStatus.OK);
		}

		return new ResponseEntity<>(wallet,HttpStatus.NOT_ACCEPTABLE);
	}

	@PutMapping("/pay/{profileId}")
	public ResponseEntity<Ewallet> payMoney(@PathVariable int profileId, @RequestParam("currentBalance") double amount) {
		Ewallet wallet = service.getById(profileId);
		double currentBalance = wallet.getCurrentBalance();
		if (amount < currentBalance && amount > 0) {
			wallet.setCurrentBalance(wallet.getCurrentBalance() - amount);
			service.update(wallet, amount, Withdraw);
			return new ResponseEntity<Ewallet>(wallet,HttpStatus.OK);
		}
		return new ResponseEntity<Ewallet>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/statements/{profileId}")
	public ResponseEntity<List<Statement>> getStatementsById(@PathVariable int profileId) {
		List<Statement> statements = service.getStatementsById(profileId);
		if (statements.isEmpty())
			return new ResponseEntity<List<Statement>>(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<List<Statement>>(statements, HttpStatus.OK);
	}

	@GetMapping("/statements")
	public Ewallet getStatements() {
		List<Statement> statements = service.getStatements();
		Ewallet wallet = new Ewallet();
		wallet.setStatements(statements);
		if (statements.isEmpty())
			return null;
		return wallet;
	}

	@DeleteMapping("/{profileId}")
	public void deleteById(@PathVariable int profileId) {
		service.deleteByid(profileId);
	}

}
