/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import com.DAO.WishlistItem;
import com.DAO.bookdao;
import com.DB.DBConnect;
import com.entity.Message;
import com.entity.WishlistImp;
import com.entity.bookdtl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(name = "AddToWishlistServlet", urlPatterns = {"/AddToWishlistServlet"})
public class AddToWishlistServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

   // Get the user email and book ID from the HTTP POST request
String userEmail = request.getParameter("useremail");
int bookId = Integer.parseInt(request.getParameter("bookId"));

// Add the book ID to the user's wishlist
WishlistItem dao;
      try {
          dao = new WishlistItem(DBConnect.getConnection());
     
if (dao.AddBook(userEmail, bookId)) {
    // Book ID added to wishlist
    response.sendRedirect("home.jsp");
} else {
//    // Book ID already exists in wishlist
     Message m= new Message("Book ID already exists in wishlist","error","alert-danger");
              HttpSession s=request.getSession();
            s.setAttribute("msg",m);
           response.sendRedirect("home.jsp");
//    request.setAttribute("errorMessage", "Book already in wishlist");
//    RequestDispatcher rd = request.getRequestDispatcher("wishlist.jsp");
//    rd.forward(request, response);
}
 } catch (ClassNotFoundException ex) {
          Logger.getLogger(AddToWishlistServlet.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(AddToWishlistServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
}
}
