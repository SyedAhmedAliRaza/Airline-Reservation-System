/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.airline;

import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Lenovo
 */


public class Airline {

   


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for a flight");
            System.out.println("2. Check seat availability");
            System.out.println("3. Make a reservation");
            System.out.println("4. View passenger list");
            System.out.println("5. Cancel a reservation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter day: ");
                    int day = scanner.nextInt();
                    System.out.print("Enter month: ");
                    int month = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter departure airport code: ");
                    String departureAirport = scanner.nextLine();
                    System.out.print("Enter destination airport code: ");
                    String destinationAirport = scanner.nextLine();
                    System.out.print("Enter airline ID: ");
                    String airlineID = scanner.nextLine();
                    String searchResult = manager.searchFlight(day, month, year, departureAirport, destinationAirport, airlineID);
                    if (!searchResult.isEmpty()) {
                        System.out.println("Flight found: " + searchResult);
                    } else {
                        System.out.println("No flight found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter flight ID: ");
                    String flightID = scanner.nextLine();
                    String seatAvailability = manager.searchFlightSeatAvailability(flightID);
                    if (!seatAvailability.isEmpty()) {
                        System.out.println("Seat availability: " + seatAvailability);
                    } else {
                        System.out.println("No flight found with the given ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter flight ID: ");
                    flightID = scanner.nextLine();
                    System.out.print("Enter your first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter your last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter your address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter your city: ");
                    

                    Passenger[] passengers = new Passenger[1];
                    passengers[0] = new Passenger(new Name(), new Address());

                    Seat[] seats = manager.getSeatDetails(flightID);
                    if (seats != null && seats.length > 0) {
                        seats[0].setStatus(true); // Reserve the first seat
                        Reservation reservation = manager.makeReservation(1, passengers, flightID, manager.getDeparturedate(flightID), new Seat[]{seats[0]});
                        System.out.println("Reservation made: " + reservation);
                    } else {
                        System.out.println("No available seats to reserve.");
                    }
                    break;

                case 4:
                    System.out.print("Enter flight ID: ");
                    flightID = scanner.nextLine();
                    List<Passenger> passengerList = manager.viewPassengerList(flightID);
                    if (!passengerList.isEmpty()) {
                        for (Passenger passenger : passengerList) {
                            System.out.println(passenger);
                        }
                    } else {
                        System.out.println("No passengers found for the flight.");
                    }
                    break;

                case 5:
                    System.out.print("Enter reservation number: ");
                    int resNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    manager.cancelReservation(resNumber);
                    System.out.println("Reservation cancelled.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
