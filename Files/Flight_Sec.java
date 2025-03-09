/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;

/**
 *
 * @author Lenovo
 */
class Flight_Sec {
     
    private Seat_Type seatType;
    
    public Flight_Sec() {
        this.seatType= null;
    }  
     
    public Flight_Sec(Seat_Type seatType) {
        this.seatType = seatType;
    }

    
    public Seat_Type getSeatType() {
        return seatType;
    }

    public void setSeatType(Seat_Type seatType, String seatID) {
        this.seatType = seatType;        
        String columnChar = ""; 
        int rawNumber = 0;  
        
        columnChar = String.valueOf(seatID.charAt(0));
        rawNumber = Integer.parseInt(seatID.substring(1));        
        if(rawNumber>=1 && rawNumber<=4){
            switch(columnChar){
                case "A":
                case "B":
                case "G":
                case "H":
                    this.seatType = Seat_Type.FIRST;
                    break;
                default:
                    System.out.println("Invalid Seat ID");
                    break;
            }
        }
        else if(rawNumber>=5 && rawNumber<=12){
            switch(columnChar){
                case "A":
                case "B":
                case "C":
                case "F":
                case "G":
                case "H":
                    this.seatType= Seat_Type.BUSINESS;
                    break;
                default:
                    System.out.println("Invalid Seat ID");
                    break;
            }
        }
        else if(rawNumber>=13 && rawNumber<=60){
            switch(columnChar){
                case "A":
                case "B":
                case "C":
                case "D":
                case "E":
                case "F":
                case "G":
                case "H":
                    this.seatType = Seat_Type.ECONOMY;
                    break;
                default:
                    System.out.println("Invalid Seat ID");
                    break;
            }
        }
        
    }

    @Override
    public String toString() {
        return "Seat Class: " + seatType ;
    }

   
   

   
}
