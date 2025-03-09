/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;

/**
 *
 * @author Lenovo
 */
class Seat {
     private String seatID;    
    private boolean status; 
    
public Seat(){
    
}
     
    
    public Seat(String seatID, boolean status) {
        this.seatID = seatID;
        this.status = status;
        
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
        
        if(seatID.matches("[a-z A-Z 0-9]+") && seatID.length()==3){
            this.seatID = seatID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airline ID");
        }  
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getSeatID() {       
        return seatID;
    }

    public boolean getStatus() {
       return status;
    }
    
    @Override
    public String toString() {
        return this.getSeatID() + "\t" + this.getStatus();
    }
    
}
