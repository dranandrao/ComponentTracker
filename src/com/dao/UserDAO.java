/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.ConnectionProvider;

/**
 * @author dranandrao
 *
 */
public class UserDAO {
	private static Connection conn;
	private static ResultSet resultset;
	private static PreparedStatement preparedStatement;

	public static String isUserAuthenticate(String username, String password) {
		conn = ConnectionProvider.getConnection();
		StringBuilder isUser = new StringBuilder();
		try {
			preparedStatement = conn.prepareStatement("select * from users where username = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultset = preparedStatement.executeQuery();
			if (resultset != null && resultset.next()) {
				isUser.append(resultset.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUser.toString();
	}

}
