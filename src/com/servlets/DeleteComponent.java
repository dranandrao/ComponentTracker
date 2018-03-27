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
		if (!component_ID.trim().isEmpty()) {
			ComponentDAO componentDAO = new ComponentDAO();
			int result = componentDAO.delteComponent(component_ID);
			if (result > 0) {
				request.getRequestDispatcher("GetComponents").forward(request, response);
			} else {
				request.getRequestDispatcher("GetComponents").include(request, response);
				response.getWriter().append("Something went wrong..! Contact Administrator").flush();
			}
		} else {
			response.sendRedirect("Login.html");
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
