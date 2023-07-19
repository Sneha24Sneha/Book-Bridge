/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author hp
 */
public class BookDtls {
    private int Bid;
     
   private String BookName;
   private String BookCategiries;
   private String SubCategiries;
    private String AuthorName;
   private String AdditionYear;
  private  String BookMRP;
   private String Bookimage;
   private String Description;
   private String Price;
   private String DealType;
   private String location;
    private String email;

    public BookDtls(String BookName, String BookCategiries, String SubCategiries, String AuthorName, String AdditionYear, String BookMRP, String Bookimage, String Description, String Price, String DealType, String location) {
        this.BookName = BookName;
        this.BookCategiries = BookCategiries;
        this.SubCategiries = SubCategiries;
        this.AuthorName = AuthorName;
        this.AdditionYear = AdditionYear;
        this.BookMRP = BookMRP;
        this.Bookimage = Bookimage;
        this.Description = Description;
        this.Price = Price;
        this.DealType = DealType;
        this.location = location;
    }
    
    public String getBookName() {
        return BookName;
    }

    public String getBookCategiries() {
        return BookCategiries;
    }

    public String getSubCategiries() {
        return SubCategiries;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public String getAdditionYear() {
        return AdditionYear;
    }

    public String getBookMRP() {
        return BookMRP;
    }

    public String getBookimage() {
        return Bookimage;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public String getDealType() {
        return DealType;
    }

    public String getLocation() {
        return location;
    }
      public String getEmail() {
        return email;
    }
 

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public void setBookCategiries(String BookCategiries) {
        this.BookCategiries = BookCategiries;
    }

    public void setSubCategiries(String SubCategiries) {
        this.SubCategiries = SubCategiries;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public void setAdditionYear(String AdditionYear) {
        this.AdditionYear = AdditionYear;
    }

    public void setBookMRP(String BookMRP) {
        this.BookMRP = BookMRP;
    }

    public void setBookimage(String Bookimage) {
        this.Bookimage = Bookimage;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setDealType(String DealType) {
        this.DealType = DealType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

  
    public void setEmail(String email) {
        this.email = email;
    }

   

   
    public BookDtls(String BookName, String BookCategiries, String SubCategiries, String AuthorName, String AdditionYear, String BookMRP, String Bookimage, String Description, String Price, String DealType, String location, String email) {
        this.BookName = BookName;
        this.BookCategiries = BookCategiries;
        this.SubCategiries = SubCategiries;
        this.AuthorName = AuthorName;
        this.AdditionYear = AdditionYear;
        this.BookMRP = BookMRP;
        this.Bookimage = Bookimage;
        this.Description = Description;
        this.Price = Price;
        this.DealType = DealType;
        this.location = location;
        this.email = email;
    }

   

    @Override
    public String toString() {
        return "BookDtls{" + "Bid=" + Bid + ", BookName=" + BookName + ", BookCategiries=" + BookCategiries + ", SubCategiries=" + SubCategiries + ", AuthorName=" + AuthorName + ", AdditionYear=" + AdditionYear + ", BookMRP=" + BookMRP + ", Bookimage=" + Bookimage + ", Description=" + Description + ", Price=" + Price + ", DealType=" + DealType + ", location=" + location + ", email=" + email + '}';
    }

    public BookDtls(String BookName, String BookCategiries, String SubCategiries, String AuthorName, String AdditionYear, String BookMRP, String Description, String Price, String DealType, String location) {
        this.BookName = BookName;
        this.BookCategiries = BookCategiries;
        this.SubCategiries = SubCategiries;
        this.AuthorName = AuthorName;
        this.AdditionYear = AdditionYear;
        this.BookMRP = BookMRP;
        this.Description = Description;
        this.Price = Price;
        this.DealType = DealType;
        this.location = location;
    }

  
  

   

    
    
}
