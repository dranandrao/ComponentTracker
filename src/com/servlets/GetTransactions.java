package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Component;
import com.beans.Transaction;
import com.dao.ComponentDAO;
import com.dao.TransactionDAO;

/**
 * Servlet implementation class GetTransactions
 */
@WebServlet("/GetTransactions")
public class GetTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTransactions() {
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
		if (request.getSession(false) != null) {
			int userRegnumber = Integer.parseInt((String) request.getAttribute("userRegnumber"));
			TransactionDAO TransactionDAO = new TransactionDAO();
			ArrayList<Transaction> transactions = TransactionDAO.getTransaction(userRegnumber);
			request.setAttribute("transactions", transactions);
			request.getRequestDispatcher("UserDashBoard.jsp").forward(request, response);
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
