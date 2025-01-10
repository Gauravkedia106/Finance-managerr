package com.personalfinancemanager.dao;

import com.personalfinancemanager.model.User;

import java.sql.*;

public class UserDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finance_manager";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Root";

    public User getUserByEmail(String email) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        }
        return null;
    }
    
    public boolean addUser(User user) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            return stmt.executeUpdate() > 0;
        }
    }
}
