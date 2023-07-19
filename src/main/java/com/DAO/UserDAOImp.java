/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;


import com.entity.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
// */
public class UserDAOImp{
    private final Connection conn;

    public UserDAOImp(Connection conn) {
        super();
        this.conn = conn;
    }

    
        public boolean userRagister(user us) {
        boolean f=false;
        try{
            String sql="insert into ragister(username,email,contact,password)value(?,?,?,?)";
            PreparedStatement ps=this.conn.prepareStatement(sql);
            ps.setString(1,us.getUsername());
             ps.setString(2,us.getEmailid());
              ps.setString(3,us.getContact());
              ps.setString(4,us.getPassword());
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

   //get user by useremail and userpassword:
        public user getUserByEmailAndPassword(String email,String password){
       user us=null;
       try{
         String query="select*from ragister where email=? and password=?";
         PreparedStatement ps=this.conn.prepareStatement(query);
          ps.setString(1,email);
           ps.setString(2,password);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               us=new user();
               //data from db
              
               //set user object
              
               String username=rs.getString("name");
               //set user object
               us.setUsername(username);
               int id=rs.getInt("id");
                us.setUserid(id);
              
                String emailid=rs.getString("email");
                us.setEmailid(emailid);
                 String contact=rs.getString("contact");
                us.setContact(contact);
               
           }
       }catch(Exception e){
           e.getStackTrace();
           
       }
   return us;
   }
}

  

