/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.bookdtl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class WishlistItem {
     private final Connection conn;

    public WishlistItem(Connection conn) {
        this.conn = conn;
    }
  public boolean AddBook(String userEmail, int bookId) {
    boolean success = false;
    try {
        // Check if the book ID already exists in the user's wishlist
        String checkQuery = "SELECT COUNT(*) FROM wishlist WHERE useremail = ? AND BookId = ?";
        PreparedStatement checkStatement = this.conn.prepareStatement(checkQuery);
        checkStatement.setString(1, userEmail);
        checkStatement.setInt(2, bookId);
        ResultSet checkResult = checkStatement.executeQuery();
        if (checkResult.next() && checkResult.getInt(1) > 0) {
            // Book ID already exists in the user's wishlist
            System.out.println("Book ID already exists in wishlist");
        } else {
            // Book ID does not exist in the user's wishlist, add it
            String addQuery = "INSERT INTO wishlist (useremail, BookId, TimeStamp) VALUES (?, ?, NOW())";
            PreparedStatement addStatement = this.conn.prepareStatement(addQuery);
            addStatement.setString(1, userEmail);
            addStatement.setInt(2, bookId);
            int rowsAffected = addStatement.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Book ID added to wishlist");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return success;
}

    }


