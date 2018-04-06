package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Transaction;
import com.dao.TransactionDAO;

/**
 * Servlet implementation class CreateTransaction
 */
@WebServlet("/CreateTransaction")
public class CreateTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTransaction() {
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
		String universityNumber = request.getParameter("universityNumber");
		String componentID = request.getParameter("componentID");
		String quantity = request.getParameter("quantity");
		String borrowDate = request.getParameter("borrowDate");
		String faculty = request.getParameter("faculty");
		if (!universityNumber.trim().isEmpty() && !componentID.trim().isEmpty() && !quantity.trim().isEmpty()
				&& !borrowDate.trim().isEmpty() && !faculty.trim().isEmpty()) {
			Transaction transaction = new Transaction();
			transaction.setUniversity_number(Integer.parseInt(universityNumber));
			transaction.setBorrow_date(borrowDate);
			transaction.setFaculty(faculty);
			transaction.setQuantity(Integer.parseInt(quantity));
			transaction.setComponent_id(Integer.parseInt(componentID));
			TransactionDAO transactionDAO = new TransactionDAO();
			int result = transactionDAO.createTransaction(transaction);
			if (result == 1) {
				request.getRequestDispatcher("GetComponents").forward(request, response);
			} else {
				response.getWriter().append("Error..!! Transaction not added.");
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
