package com.personalfinancemanager.dao;

import com.personalfinancemanager.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finance_manager";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public boolean addTransaction(Transaction transaction) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO transactions (user_id, category_id, amount, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, transaction.getUserId());
            stmt.setInt(2, transaction.getCategoryId());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setString(4, transaction.getDescription());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Transaction> getTransactions(int userId) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM transactions WHERE user_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setUserId(rs.getInt("user_id"));
                transaction.setCategoryId(rs.getInt("category_id"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDescription(rs.getString("description"));
                transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
