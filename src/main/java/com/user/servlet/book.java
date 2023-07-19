/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import com.DAO.BookDAOImp;
import com.DAO.bookdao;
import com.DB.DBConnect;
import com.entity.bookdtl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author hp
 */
@MultipartConfig
public class book extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet book</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet book at " + request.getContextPath() + "</h1>");
             try{
               
            String BookName =request.getParameter("Title");
            String BookCategiries =request.getParameter("categories");
            String SubCategiries =request.getParameter("subcategories");
            String AuthorName =request.getParameter("Author");
            String AdditionYear =request.getParameter("Addition");
            String BookMRP =request.getParameter("MRP");
            String Description =request.getParameter("discription");
            String price =request.getParameter("price");
            String DealType =request.getParameter("Dealtype");
            String Location =request.getParameter("location");
           
             Part part=request.getPart("image");
            String filename =part.getSubmittedFileName();
            String email =request.getParameter("email");
            String Contact =request.getParameter("Contact");
            String Quantity =request.getParameter("Quantity");
            // bookdtl bd=new bookdtl(bookname,filename,email);
             bookdtl bd=new bookdtl(BookName,BookCategiries,SubCategiries,AuthorName,AdditionYear,BookMRP,Description,price,DealType,Location,filename,email,Contact,Quantity);
            bookdao dao=new bookdao(DBConnect.getConnection());
            if(dao.AddBook(bd)){
                out.println("done");
               String path = getServletContext().getRealPath("") + File.separator + "book";
File file = new File(path);
if (!file.exists()) {
    file.mkdirs(); // Create the directory if it does not exist
}
String fullFilePath = path + File.separator + filename; // Make sure 'filename' is properly defined
//response.setContentType("text/html"); // Set the response content type to HTML
//PrintWriter out = response.getWriter(); // Get the response output stream

out.println("File path: " + fullFilePath); // Output the file path to the response

part.write(fullFilePath);
                //response.sendRedirect("newjsp.jsp");
            }
           else{
            out.println("error");
                }
                }catch(Exception e)
            {
                e.printStackTrace();
            }  
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

