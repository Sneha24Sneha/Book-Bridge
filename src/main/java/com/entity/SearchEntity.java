/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;
public class SearchEntity {
    
    private String Tittle;
    private String Category;
    private String Location;

    public String getTittle() {
        return Tittle;
    }

    public String getCategory() {
        return Category;
    }

    public String getLocation() {
        return Location;
    }

    public void setTittle(String Tittle) {
        this.Tittle = Tittle;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public SearchEntity(String Tittle, String Category, String Location) {
        this.Tittle = Tittle;
        this.Category = Category;
        this.Location = Location;
    }

    public SearchEntity() {
        super();
        
    }
    
    
}
