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

import com.beans.Component;
import com.utils.ConnectionProvider;

/**
 * @author dranandrao
 *
 */
public class ComponentDAO {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public ComponentDAO() {
		// TODO Auto-generated constructor stub
		conn = ConnectionProvider.getConnection();
	}

	public ArrayList<Component> getComponents() {
		ArrayList<Component> components = new ArrayList<Component>();
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from components");
			Component component = null;
			while (resultSet.next()) {
				component = new Component();
				component.setComponent_id(resultSet.getInt(1));
				component.setComponent_name(resultSet.getString(2));
				component.setQuantity(resultSet.getInt(3));
				component.setBranch(resultSet.getString(4));
				components.add(component);
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
		return components;
	}
}
