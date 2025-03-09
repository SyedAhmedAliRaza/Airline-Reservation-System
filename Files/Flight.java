/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
/**
 *
 * @author Lenovo
 */
class Flight {
    
    private String flightNumber;
    private String departureDate;
    private String departureAirport;
    private String destinationAirport;
    private String departureTime;
    private String arrivalTime;
   
     public Flight() {   
    }

    
    public Flight(String flightNumber, int day, int month, int year, String departureAirport, String destinationAirport, String departureTime, String arrivalTime) {
        String airlineID = flightNumber.substring(0,2);
        String number = flightNumber.substring(2);
        this.setFlightNumber(airlineID, number);        
        setDepartureDate(day, month, year);
        this.departureAirport = departureAirport.toUpperCase();
        this.destinationAirport = destinationAirport.toUpperCase();
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    static class Date {

        public Date(int day, int month, int year) {
        }
    }
    
    public void setFlightNumber(String airlineID, String number) {        
        if(airlineID.matches("[a-z A-Z]+") && airlineID.length()==2 && number.matches("[0-9 ]+")){
            this.flightNumber = airlineID + number;
            
        }
        else{
            System.out.println("Invalid Flight Number");
        }        
        
    }
    
    public void setDepartureDate(int day, int month, int year) {             
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");     
        Calendar calendar1 = new GregorianCalendar(year, month-1, day);     
        this.departureDate = sdf.format(calendar1.getTime());
    }    

    public void setDepartureAirport(String departureAirport) {
        
        if(departureAirport.matches("[a-zA-Z]+") && departureAirport.length()==3){
            this.departureAirport = departureAirport.toUpperCase();
        }
        else{
            System.out.println("Invalid Airport ID");
        }
        
    }  

    public void setDestinationAirport(String destinationAirport) {
       
       if(destinationAirport.matches("[a-zA-Z]+") && destinationAirport.length()==3){
            this.destinationAirport = destinationAirport.toUpperCase();
        }
        else{
            System.out.println("Invalid Airport ID");
        } 
        
        
    }  

    public void setDepartureTime(int hour, int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");     
        Calendar calendar1 = new GregorianCalendar(2016, 12, 5, hour, minute);   
        this.departureTime = sdf.format(calendar1.getTime());
        
    }  

    public void setArrivalTime(int hour, int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ");     
        Calendar calendar1 = new GregorianCalendar(2016, 12, 5, hour, minute);   
        this.arrivalTime = sdf.format(calendar1.getTime());
    }  

    
    
    public String getFlightNumber() {
        return flightNumber;
    }
    
    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

     public String getDepartureTime() {
        return departureTime;
    }
    
      public String getArrivalTime() {
        return arrivalTime;
    }
     
    
    @Override
    public String toString() {
        return flightNumber + "," + departureDate + "," + departureAirport + "," + destinationAirport + "," + departureTime + "," + arrivalTime ;
    }

   
   
    
}
