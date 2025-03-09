/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;

/**
 *
 * @author Lenovo
 */
class Address {
    String street;
     String city;
    String passport;
      public Address() {
    }    
     
    public Address(String street, String city, String passport) {
        this.street = street;
        this.city = city;
        this.passport = passport;
    }   

   

    public void setStreet(String street) {
        this.street = street;
    }    

    public void setCity(String city) {
        this.city = city;
    }
    
    
    public void setpassport(String passport) {
        this.passport = passport;
    }
    
     public String getStreet() {
        return street;
    }
     
    public String getCity() {
        return city;
    }
    
    public String getpassport() {
        return passport;
    }

    @Override
    public String toString() {
        return street + " " + city + " " + passport;
    }
}
