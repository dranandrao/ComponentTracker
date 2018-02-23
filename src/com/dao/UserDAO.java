/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.User;
import com.utils.ConnectionProvider;

/**
 * @author dranandrao
 *
 */
public class UserDAO {
	private static Connection conn;
	private static ResultSet resultset;
	private static PreparedStatement preparedStatement;

	public static boolean isUserAuthenticate(String username, String password) {
		conn = ConnectionProvider.getConnection();
		boolean isUser = false;
		try {
			preparedStatement = conn.prepareStatement("select * from users where username = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultset = preparedStatement.executeQuery();
			if (resultset != null && resultset.next()) {
				isUser = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUser;
	}
	
}
