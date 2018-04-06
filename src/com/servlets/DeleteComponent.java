package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ComponentDAO;

/**
 * Servlet implementation class DeleteComponent
 */
@WebServlet("/DeleteComponent")
public class DeleteComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteComponent() {
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
		if (request.getSession(false) != null) {
			if (!component_ID.trim().isEmpty()) {
				ComponentDAO componentDAO = new ComponentDAO();
				int result = componentDAO.delteComponent(component_ID);
				if (result > 0) {
					request.getRequestDispatcher("GetComponents").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Error..Component not removed..Try again..!");
					request.getRequestDispatcher("GetComponents").include(request, response);
				}
			} else {
				request.setAttribute("errorMsg", "Something went wrong..!");
				request.getRequestDispatcher("GetComponents").include(request, response);
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
