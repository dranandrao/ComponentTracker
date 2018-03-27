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

	// retrives the components present in table.
	public ArrayList<Component> getComponents() {
		ArrayList<Component> components = new ArrayList<Component>();
		try {
			conn = ConnectionProvider.getConnection();
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

	// creates the component.
	public int createComponent(String component_name, int quantity, String branch) {
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			preparedStatement = conn.prepareStatement("Insert into components value(?,?,?)");
			preparedStatement.setString(2, component_name);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setString(4, branch);
			result = preparedStatement.executeUpdate();
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

	public int updateComponent(String component_ID, String component_name, String quantity, String branch) {
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			preparedStatement = conn.prepareStatement("update components set component_name = ?, quantity = ?, branch = ? where component_ID = ?");
			preparedStatement.setInt(4, Integer.parseInt(component_ID));
			preparedStatement.setString(1, component_name);
			preparedStatement.setInt(2, Integer.parseInt(quantity));
			preparedStatement.setString(3, branch);
			result = preparedStatement.executeUpdate();
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
