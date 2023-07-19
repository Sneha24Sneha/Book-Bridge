/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author hp
 */
public class user {
    private int userid;
    private String username;
    private String emailid;
    private String contact;
    private String Password;

    public String getUsername() {
        return username;
    }

    public String getContact() {
        return contact;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public user(int userid, String username, String emailid) {
        this.userid = userid;
        this.username = username;
        this.emailid = emailid;
    }

    public user(int userid, String username, String emailid, String contact, String Password) {
        this.userid = userid;
        this.username = username;
        this.emailid = emailid;
        this.contact = contact;
        this.Password = Password;
    }

   

    public user(String username, String emailid, String contact, String Password) {
        this.username = username;
        this.emailid = emailid;
        this.contact = contact;
        this.Password = Password;
    }
    
//
    public String getEmailid() {
        return emailid;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
     public void setContact(String contact) {
        this.contact = contact;
    }
    public user() {
        super();
    }

    @Override
    public String toString() {
        return "user{" + "userid=" + userid + ", username=" + username + ", emailid=" + emailid + ", contact=" + contact + ", Password=" + Password + '}';
    }

   

    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

  
    public user(String emailid, String Password) {
        this.emailid = emailid;
        this.Password = Password;
    }
    
    
}
