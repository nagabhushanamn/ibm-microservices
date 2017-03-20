package com.bank.service;

public interface TxrService {

	boolean doTxr(double amount, String fromAcc, String toAcc);

}
