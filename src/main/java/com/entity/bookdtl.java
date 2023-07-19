/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author hp
 */
public class bookdtl {
    private int BookId;
     private String BookName;
      private String BookCategiries;
   private String SubCategiries;
    private String AuthorName;
   private String AdditionYear;
  private  String BookMRP;
    private String Description;
   private String Price;
   private String DealType;
   private String location;
     private String Bookpath;
     private String email;
      private String Contact;
      private String Quantity;
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public bookdtl(String BookName, String Bookpath) {
        this.BookName = BookName;
        this.Bookpath = Bookpath;
    }

   
    public bookdtl(String BookName) {
        this.BookName = BookName;
    }
 
    public bookdtl(String BookName, String BookCategiries, String location) {
        this.BookName = BookName;
        this.BookCategiries = BookCategiries;
        this.location = location;
    }
    

    public bookdtl(String BookName, String BookCategiries, String SubCategiries, String AuthorName, String AdditionYear, String BookMRP, String Description, String Price, String DealType, String location, String Bookpath, String email, String Contact) {
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
        this.Bookpath = Bookpath;
        this.email = email;
        this.Contact = Contact;
    }

    public bookdtl(String BookName, String BookCategiries, String SubCategiries, String AuthorName, String AdditionYear, String BookMRP, String Description, String Price, String DealType, String location, String Bookpath, String email, String Contact, String Quantity) {
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
        this.Bookpath = Bookpath;
        this.email = email;
        this.Contact = Contact;
        this.Quantity = Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getContact() {
        return Contact;
    }

    public bookdtl() {
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

   

   

    public bookdtl(String BookName, String BookCategiries, String SubCategiries, String AuthorName, String AdditionYear, String BookMRP, String Description, String Price, String DealType, String location, String Bookpath, String email) {
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
        this.Bookpath = Bookpath;
        this.email = email;
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
 public void setBookpath(String Bookpath) {
        this.Bookpath = Bookpath;
    }

    public String getBookpath() {
        return Bookpath;
    }
 public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
//    @Override
//    public String toString() {
//        return "bookdtl{" + "BookName=" + BookName + ", Bookpath=" + Bookpath + ", email=" + email + '}';
//    }

    @Override
    public String toString() {
        return "bookdtl{" + "BookName=" + BookName + ", BookCategiries=" + BookCategiries + ", SubCategiries=" + SubCategiries + ", AuthorName=" + AuthorName + ", AdditionYear=" + AdditionYear + ", BookMRP=" + BookMRP + ", Description=" + Description + ", Price=" + Price + ", DealType=" + DealType + ", location=" + location + ", Bookpath=" + Bookpath + ", email=" + email + '}';
    }

    public bookdtl(int BookId) {
        this.BookId = BookId;
    }

   
    

    
     
    
}
