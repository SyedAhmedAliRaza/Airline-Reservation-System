/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;

/**
 *
 * @author Lenovo
 */
class Passenger {
     private Name name;
    private Address address;
   

    

    public Passenger(Name name, Address address) {
        this.name = name;
        this.address = address;

    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   
    
    public Name getName() {
        return name;
    }
    
    public Address getAddress() {
        return address;
    }
   

    @Override
    public String toString() {
        return name + "@" + address ;
    }

  
     
}
