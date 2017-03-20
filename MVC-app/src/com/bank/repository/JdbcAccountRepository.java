package com.bank.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.db.MySQLConnection;
import com.bank.model.Account;
import com.bank.model.AccountType;

public class JdbcAccountRepository implements AccountRepository {

	@Override
	public Account load(String num) {
		Account account = null;
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "select * from bank.ACCOUNTS where num=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account = new Account();
				account.setNum(rs.getString("num"));
				account.setName(rs.getString("name"));
				account.setBalance(rs.getDouble("balance"));
				account.setType(AccountType.valueOf(rs.getString("acc_type")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public boolean update(Account account) {

		boolean status = false;
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "update bank.ACCOUNTS set balance=? where num=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setString(2, account.getNum());
			status = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
