/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import com.DAO.bookdao;
import com.DB.DBConnect;
import com.entity.bookdtl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DBConnect db;

    public SearchServlet() {
        super();
        db = new DBConnect();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String category = request.getParameter("category");
       
        String location = request.getParameter("location");
        String DealType = request.getParameter("DealType");
      bookdao dao;
        try {
            dao = new bookdao(DBConnect.getConnection()); // create an instance of BookDAO
            List<bookdtl> books;

                 
         books = dao.getBooksByLocationCategoryAndName(bookName, category, location); // call the getBooksByLocationCategoryAndName() methodb
        request.setAttribute("books", books);
        RequestDispatcher rd = request.getRequestDispatcher("booklist.jsp");
        rd.forward(request, response);
             

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
