package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ComponentDAO;

/**
 * Servlet implementation class UpdateComponent
 */
@WebServlet("/UpdateComponent")
public class UpdateComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String component_ID = request.getParameter("component_ID");
		String component_name = request.getParameter("component_name");
		String quantity = request.getParameter("quantity");
		if (request.getSession(false) != null) {
			if (!component_ID.trim().isEmpty() && !component_name.trim().isEmpty() && !quantity.trim().isEmpty()) {
				ComponentDAO componentDAO = new ComponentDAO();
				int result = componentDAO.updateComponent(component_ID, component_name, quantity);
				if (result == 1) {
					request.getRequestDispatcher("GetComponents").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Error..Component not updated..Try again..!");
					request.getRequestDispatcher("GetComponents").include(request, response);
				}
			} else {
				request.setAttribute("errorMsg", "Please fill the form completely..!");
				request.getRequestDispatcher("UpdateComponent.jsp").include(request, response);
			}
		} else {
			request.getRequestDispatcher("LogoutServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
