/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.SearchEntity;
import com.user.servlet.book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchDaoIMP {
     private final Connection conn;

    public SearchDaoIMP(Connection conn) {
        this.conn = conn;
    }
      public SearchEntity getBooksByLocation(String Tittle,String Category,String Location){
       SearchEntity b=null;
       try{
         String query="select*from book where BookName=? and BookCategires=? and Location=?";
         PreparedStatement ps=this.conn.prepareStatement(query);
          ps.setString(1,Tittle);
           ps.setString(2,Category);
            ps.setString(3,Location);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               b=new SearchEntity();
               //data from db
              
               //set user object
              
               String title=rs.getString("BookName");
               //set user object
              
                b.setTittle(title);
                 String category=rs.getString("BookCategires");
               //set user object
               b.setCategory(category);
               
              
                String location=rs.getString("Location");
                b.setLocation(location);
                
               
           }
       }catch(Exception e){
           e.getStackTrace();
           
       }
   
   return b;
      }
}
