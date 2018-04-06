package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.beans.Transaction;
import com.utils.ConnectionProvider;

public class TransactionDAO {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	// Retrives the components present in table.
	public ArrayList<Transaction> getTransaction(int registerNumber) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement("select * from transaction where university_number = ?");
			preparedStatement.setInt(1, registerNumber);
			resultSet = preparedStatement.executeQuery();

			Transaction transaction = null;
			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setUniversity_number(resultSet.getInt(1));
				transaction.setComponent_id(resultSet.getInt(2));
				transaction.setQuantity(resultSet.getInt(3));
				transaction.setFaculty(resultSet.getString(4));
				transaction.setBorrow_date(resultSet.getString(5));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return transactions;
	}

	public ArrayList<Transaction> getTransaction() {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			String sql = "select * from transaction";
			conn = new ConnectionProvider().getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			Transaction transaction = null;
			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setUniversity_number(resultSet.getInt(1));
				transaction.setComponent_id(resultSet.getInt(2));
				transaction.setQuantity(resultSet.getInt(3));
				transaction.setFaculty(resultSet.getString(4));
				transaction.setBorrow_date(resultSet.getString(5));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return transactions;
	}

	public int createTransaction(Transaction transaction) {
		int result = 0;
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement("Insert into transaction value(?,?,?,?,?)");
			preparedStatement.setInt(1, transaction.getUniversity_number());
			preparedStatement.setInt(2, transaction.getComponent_id());
			preparedStatement.setInt(3, transaction.getQuantity());
			preparedStatement.setString(4, transaction.getFaculty());
			preparedStatement.setDate(5, Date.valueOf(transaction.getBorrow_date()));
			boolean isAvailable = new ComponentDAO().checkIfComponentIsAvl(transaction.getComponent_id(),
					transaction.getQuantity());
			if (isAvailable) {
				result = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
