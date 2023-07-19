/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.bookdtl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class bookdao {
    private final Connection conn;

    public bookdao(Connection conn) {
        this.conn = conn;
    }
     public boolean AddBook( bookdtl bd) {
        boolean f=false;
        try{
            String sql="insert into book(BookName,BookCategiries, SubCategiries,AuthorName,AdditionYear,BookMRP,Description,price,DealType,Location,Path,email,Contact,Quantity)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=this.conn.prepareStatement(sql);
           
             ps.setString(1,bd.getBookName());
             ps.setString(2,bd.getBookCategiries());
             ps.setString(3,bd.getSubCategiries());
              ps.setString(4,bd.getAuthorName());
             ps.setString(5,bd.getAdditionYear());
             ps.setString(6,bd.getBookMRP());
              ps.setString(7,bd.getDescription());
             ps.setString(8,bd.getPrice());
             ps.setString(9,bd.getDealType());
              ps.setString(10,bd.getContact());
             ps.setString(11,bd.getBookpath());
             ps.setString(12,bd.getEmail());
             ps.setString(13,bd.getContact());
             ps.setString(14,bd.getQuantity());
              int i=ps.executeUpdate();
              if(i==1){
                  f=true;
              }
               }
        catch (Exception e){
            e.printStackTrace();
            
        }
        return f;
    }
    public List<bookdtl>getAllProducts(){
        
        List<bookdtl> list = new ArrayList<bookdtl>();
        bookdtl b=null;
        try{
             String query="select*from book ";
         PreparedStatement ps=this.conn.prepareStatement(query);
//          ps.setString(1,"Title");
//           ps.setString(2,"Category");
//            ps.setString(3,"Location");
            ResultSet rs=ps.executeQuery();
            int i=1;
            while(rs.next() && i<=8){
               b=new bookdtl();
               b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));
             b.setContact(rs.getString(14));
              b.setQuantity(rs.getString(15));
               
               list.add(b);
               i++;
               
            }
        }catch(Exception e)
        {
           e.printStackTrace();
        }
        return list;
    }
    public List<bookdtl> getBooksByLocationCategoryAndName(String bookName, String category, String location) {
    List<bookdtl> list = new ArrayList<bookdtl>();
    bookdtl b = null;
    try {
        String query = "SELECT * FROM book WHERE BookCategiries = ? AND Location = ? AND BookName LIKE ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, category);
        ps.setString(2, location);
        ps.setString(3, "%" + bookName + "%");
        ResultSet rs = ps.executeQuery();
        int i = 1;
        while (rs.next() && i <= 6) {
            b = new bookdtl();
             b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));

            list.add(b);
            i++;

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
 public List<bookdtl> getBooksByCategory(String category,String subcategory) {
    List<bookdtl> list = new ArrayList<bookdtl>();
    bookdtl b = null;
    try {
        String query = "SELECT * FROM book WHERE BookCategiries=? and SubCategiries=?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, category);
         ps.setString(2, subcategory);
       
        ResultSet rs = ps.executeQuery();
        int i = 1;
        while (rs.next() && i <= 6) {
            b = new bookdtl();
            b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));
           b.setContact(rs.getString(14));
              b.setQuantity(rs.getString(15));
            list.add(b);
            i++;

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
 public List<bookdtl> getBooksByFixed() {
    List<bookdtl> list = new ArrayList<bookdtl>();
    bookdtl b = null;
    try {
        String query = "SELECT * FROM book WHERE DealType='Fixed'";
        PreparedStatement ps = this.conn.prepareStatement(query);     
        ResultSet rs = ps.executeQuery();
        int i = 1;
        while (rs.next() && i <= 6) {
            b = new bookdtl();
            b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));
            b.setContact(rs.getString(14));
              b.setQuantity(rs.getString(15));
            list.add(b);
            i++;

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
 public List<bookdtl> getBooksByNegotiabile() {
    List<bookdtl> list = new ArrayList<bookdtl>();
    bookdtl b = null;
    try {
        String query = "SELECT * FROM book WHERE DealType='Negotiable'";
        PreparedStatement ps = this.conn.prepareStatement(query);
       
       
        ResultSet rs = ps.executeQuery();
        int i = 1;
        while (rs.next() && i <= 6) {
            b = new bookdtl();
            b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));
             b.setContact(rs.getString(14));
              b.setQuantity(rs.getString(15));
            list.add(b);
            i++;

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
 public bookdtl getBooksByID(int BookId) {
   
    bookdtl b = null;
    try {
        String query = "SELECT * FROM book WHERE BookId=?";
        PreparedStatement ps = this.conn.prepareStatement(query);
       
       ps.setInt(1, BookId);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            b = new bookdtl();
             b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));
             b.setContact(rs.getString(14));
              b.setQuantity(rs.getString(15));
           
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return b;
}
// public void addWishlistItem(String useremail, int BookId) {
//  try {
//    String query = "INSERT INTO wishlist (useremail, BookId, TimeStamp) VALUES (?, ?, NOW())";
//    PreparedStatement ps = this.conn.prepareStatement(query);
//    ps.setString(1, useremail);
//    ps.setInt(2, BookId);
//    ps.executeUpdate();
//  } catch (Exception e) {
//    e.printStackTrace();
//  }
//}
//public void removeWishlistItem(String useremail, int BookId) {
//    try {
//        String query = "DELETE FROM wishlist WHERE useremail=? AND BookId=?";
//        PreparedStatement ps = conn.prepareStatement(query);
//        ps.setString(1, useremail);
//        ps.setInt(2, BookId);
//        ps.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
public List<bookdtl> getBooksByeMAIL(String email) {
    List<bookdtl> list = new ArrayList<bookdtl>();
    bookdtl b = null;
    try {
        String query = "SELECT * FROM book WHERE email=?";
        PreparedStatement ps = this.conn.prepareStatement(query);
       
       ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        int i = 1;
        while (rs.next()) {
            b = new bookdtl();
            b.setBookId(rs.getInt(1));
            b.setBookName(rs.getString(2));
            b.setBookCategiries(rs.getString(3));
            b.setSubCategiries(rs.getString(4));
            b.setAuthorName(rs.getString(5));
            b.setAdditionYear(rs.getString(6));
            b.setBookMRP(rs.getString(7));
            b.setDescription(rs.getString(8));
            b.setPrice(rs.getString(9));
            b.setDealType(rs.getString(10));
            b.setLocation(rs.getString(11));
            b.setBookpath(rs.getString(12));
            b.setEmail(rs.getString(13));
            b.setContact(rs.getString(14));
              b.setQuantity(rs.getString(15));
            list.add(b);
            i++;

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
}
