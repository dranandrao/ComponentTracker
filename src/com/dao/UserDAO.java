/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	private static Statement statement;

	public static String isUserAuthenticate(String username, String password) {
		conn = new ConnectionProvider().getConnection();
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

	public static ArrayList<User> getUsers(String username) {
		ArrayList<User> users = new ArrayList<User>();
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement("select * from users where username = ?");
			preparedStatement.setString(1, username);
			resultset = preparedStatement.executeQuery();
			User user = null;
			while (resultset.next()) {
				user = new User();
				user.setUsername(resultset.getString(1));
				user.setPassword(resultset.getString(2));
				user.setRole(resultset.getString(3));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
