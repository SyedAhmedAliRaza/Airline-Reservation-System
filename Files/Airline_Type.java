/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;

/**
 *
 * @author Lenovo
 */
 class Airline_Type {
    private String airlineID;      
    private String airlineName;    
 

   
    public Airline_Type(String airlineID, String airlineName) {
        this.airlineID = "";
        this.airlineName = "";
    }

 
    public Airline_Type() {
        this.setAirlineID(airlineID);
        this.setAirlineName(airlineName);
        
    }

    public void setAirlineID(String airlineID) {
        
        if(airlineID.matches("[a-zA-Z]+") && airlineID.length()==2){
            this.airlineID = airlineID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airline ID");
        }
        
    }

    public void setAirlineName(String airlineName) {
     
        if (airlineName.matches("[a-zA-Z ]+")) {
            this.airlineName = airlineName;
        }
        else{
            System.out.println("Invalid Airline Name");
        }
        
    }

    public String getAirlineID() {
        return airlineID; 
    }

    public String getAirlineName() {
        return airlineName;
    }
    
    @Override
    public String toString() {
        return this.getAirlineID() + "," + this.getAirlineName();
    }
}
