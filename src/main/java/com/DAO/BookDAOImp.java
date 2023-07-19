/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.BookDtls;
import com.entity.user;
import com.mysql.cj.Query;
import com.mysql.cj.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImp {
     private final Connection conn;

    public BookDAOImp(Connection conn) {
        this.conn = conn;
    }
        public boolean AddBook( BookDtls bd) {
        boolean f=false;
        try{
            String sql="insert into booksdetail(BookName,BookCategires,SubCategires,AuthorName,AdditionYear,BookMRP,img,Description,price,DealType,Location,email)value(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=this.conn.prepareStatement(sql);
           
             ps.setString(1,bd.getBookName());
              ps.setString(2,bd.getBookCategiries());
              ps.setString(3,bd.getSubCategiries());
              ps.setString(4,bd.getAuthorName());
             ps.setString(5,bd.getAdditionYear());
              ps.setString(6,bd.getBookMRP());
              ps.setString(7,bd.getBookimage());
              ps.setString(8,bd.getDescription());
             ps.setString(9,bd.getPrice());
              ps.setString(10,bd.getDealType());
              ps.setString(11,bd.getLocation());
               ps.setString(12,bd.getEmail());
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
   
    
}
