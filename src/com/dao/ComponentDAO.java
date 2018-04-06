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
			conn = new ConnectionProvider().getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from components");
			Component component = null;
			while (resultSet.next()) {
				component = new Component();
				component.setComponent_id(resultSet.getInt(1));
				component.setComponent_name(resultSet.getString(2));
				component.setQuantity(resultSet.getInt(3));
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
	public int createComponent(String component_name, int quantity) {
		int result = 0;
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement("Insert into components value(?,?,?,?)");
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, component_name);
			preparedStatement.setInt(3, quantity);
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

	public int updateComponent(String component_ID, String component_name, String quantity) {
		int result = 0;
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement(
					"update components set component_name = ?, quantity = ? where component_ID = ?");
			preparedStatement.setInt(3, Integer.parseInt(component_ID));
			preparedStatement.setString(1, component_name);
			preparedStatement.setInt(2, Integer.parseInt(quantity));
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

	public int delteComponent(String component_ID) {
		int result = 0;
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement("Delete from components where component_id = ?");
			preparedStatement.setInt(1, Integer.parseInt(component_ID));
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

	public boolean checkIfComponentIsAvl(int componentID, int quantity) {
		boolean isAvailable = false;
		try {
			conn = new ConnectionProvider().getConnection();
			preparedStatement = conn.prepareStatement("Select quantity from components where component_id = ?");
			preparedStatement.setInt(1, componentID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int componentsAvailable = resultSet.getInt(1);
				if (componentsAvailable - quantity >= 0) {
					isAvailable = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAvailable;
	}

	public int updateComponentOnTrasaction(int componentID, int quantity) {
		int result = 0;
		try {
			conn = new ConnectionProvider().getConnection();
			PreparedStatement preparedStatement1 = conn
					.prepareStatement("select quantity from components where component_id = ?");
			preparedStatement1.setInt(1, componentID);
			resultSet = preparedStatement1.executeQuery();
			if (resultSet.next()) {
				int componentQuantity = resultSet.getInt(1);
				preparedStatement = conn.prepareStatement("Update components set quantity = ? where component_id = ?");
				preparedStatement.setInt(1, (componentQuantity - quantity));
				preparedStatement.setInt(2, componentID);
				result = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
