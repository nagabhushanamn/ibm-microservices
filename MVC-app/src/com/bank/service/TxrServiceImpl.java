package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public boolean doTxr(double amount, String fromAcc, String toAcc) {

		// load fromAcc
		Account fromAccount = accountRepository.load(fromAcc);

		// load toAcc
		Account toAccount = accountRepository.load(toAcc);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// update accounts
		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		return true;
	}

}
