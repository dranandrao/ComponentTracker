package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ComponentDAO;

/**
 * Servlet implementation class CreateComponent
 */
@WebServlet("/CreateComponent")
public class CreateComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String component_name = request.getParameter("component_name");
		String quantity = request.getParameter("quantity");
		String branch = request.getParameter("branch");
		if (request.getSession(false) != null) {
			if (!component_name.trim().isEmpty() && !quantity.trim().isEmpty() && !branch.trim().isEmpty()) {
				ComponentDAO componentDAO = new ComponentDAO();
				int result = componentDAO.createComponent(component_name, Integer.parseInt(quantity), branch);
				if (result == 1) {
					request.getRequestDispatcher("GetComponents").forward(request, response);
				} else {
					response.getWriter().append("Error..!! Component not added.");
				}
			}
		} else {
			request.getRequestDispatcher("Login.html").forward(request, response);
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
