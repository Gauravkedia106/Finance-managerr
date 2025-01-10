package com.personalfinancemanager.servlet;

import com.personalfinancemanager.dao.TransactionDao;
import com.personalfinancemanager.model.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/addTransaction")
public class AddTransactionServlet extends HttpServlet {
    private TransactionDao transactionDao = new TransactionDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String description = request.getParameter("description");

        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setCategoryId(categoryId);
        transaction.setAmount(amount);
        transaction.setDescription(description);

        try {
            if (transactionDao.addTransaction(transaction)) {
                response.sendRedirect("transaction.jsp");
            } else {
                response.getWriter().println("Failed to add transaction");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
