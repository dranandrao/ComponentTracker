package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Component;
import com.dao.ComponentDAO;
import com.dao.UserDAO;

/**
 * Servlet implementation class UserAuthentication
 */
@WebServlet("/UserAuthentication")
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAuthentication() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!username.trim().isEmpty() && !password.trim().isEmpty()) {
			HttpSession session = (HttpSession) request.getSession();
			session.setMaxInactiveInterval((Integer.valueOf(getServletContext().getInitParameter("session_timeout"))));
			String userRole = UserDAO.isUserAuthenticate(username, password);
			if (userRole != null && !userRole.isEmpty()) {
				session.setAttribute("userRole", userRole);
				session.setAttribute("username", username);
				System.out.println("Sessiiooonnn attribute"+ session.getAttribute("username"));
				request.getRequestDispatcher("GetComponents").forward(request, response);
				return;
			} else {
				session.invalidate();
				response.sendRedirect("Login.html");
				return;
			}
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
