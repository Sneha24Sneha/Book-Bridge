/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author hp
 */
public class WishlistImp {
    private int Wid;
    private String useremail;
    private int BookId;

    public int getWid() {
        return Wid;
    }

    public String getUseremail() {
        return useremail;
    }

    public int getBookId() {
        return BookId;
    }

    public void setWid(int Wid) {
        this.Wid = Wid;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public WishlistImp(int Wid, String useremail, int BookId) {
        this.Wid = Wid;
        this.useremail = useremail;
        this.BookId = BookId;
    }

    public WishlistImp() {
    }

    public WishlistImp(String useremail, int BookId) {
        this.useremail = useremail;
        this.BookId = BookId;
    }
    
}
