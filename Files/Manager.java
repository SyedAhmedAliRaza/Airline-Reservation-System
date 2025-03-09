/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airline;


 import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lenovo
 */
 class Manager {
 
    private List<Airport> airports;
    private List<Airline_Type> airlines;
    private List<Flight> flights;
    private List<Seat[]> seats;
    private List<Reservation> reservations;

    public static int reservationNumber = -1;

    public Manager() {
        this.airports = new ArrayList<>();
        this.airlines = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.seats = new ArrayList<>();
        this.reservations = new ArrayList<>();

        this.initData();
    }

    private void initData() {
        // Initialize airports
        airports.add(new Airport("JFK", "New York", "USA"));
        airports.add(new Airport("LHR", "London", "UK"));
        airports.add(new Airport("CDG", "Paris", "France"));
        airports.add(new Airport("HND", "Tokyo", "Japan"));
        airports.add(new Airport("DXB", "Dubai", "UAE"));
        airports.add(new Airport("SIN", "Singapore", "Singapore"));
        airports.add(new Airport("SYD", "Sydney", "Australia"));

        // Initialize airlines
        airlines.add(new Airline_Type("AA", "American Airlines"));
        airlines.add(new Airline_Type("BA", "British Airways"));
        airlines.add(new Airline_Type("AF", "Air France"));
        airlines.add(new Airline_Type("JL", "Japan Airlines"));
        airlines.add(new Airline_Type("EK", "Emirates"));

        // Initialize flights
        flights.add(new Flight("AA100", 15, 7, 2023, "JFK", "LHR", "10:00", "22:00"));
        flights.add(new Flight("BA200", 20, 8, 2023, "LHR", "CDG", "12:00", "14:00"));
        flights.add(new Flight("AF300", 5, 9, 2023, "CDG", "HND", "13:00", "04:00"));
        flights.add(new Flight("JL400", 25, 10, 2023, "HND", "DXB", "16:00", "23:00"));
        flights.add(new Flight("EK500", 10, 11, 2023, "DXB", "SIN", "18:00", "02:00"));

        // Initialize seats for each flight
        for (Flight flight : flights) {
            seats.add(this.initSeatsForFlight());
        }
    }

    private Seat[] initSeatsForFlight() {
        Seat[] flightSeats = new Seat[448];
        for (int i = 0; i < flightSeats.length; i++) {
            String seatID = this.generateSeatID(i);
            flightSeats[i] = new Seat(seatID, false); // All seats are initially available
        }
        return flightSeats;
    }

    private String generateSeatID(int index) {
        String[] seatClasses = {"A", "B", "G", "H"};
        int rowNumber = index / seatClasses.length + 1;
        String seatClass = seatClasses[index % seatClasses.length];
        return seatClass + rowNumber;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<Airline_Type> getAirlines() {
        return airlines;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Seat[]> getSeats() {
        return seats;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public String searchFlight(int day, int month, int year, String departureAirport, String destinationAirport, String airlineID) {
        String str = "";
        for (Flight flight : flights) {
            String airlineCode = flight.getFlightNumber().substring(0, 2);
            if (airlineCode.equals(airlineID) &&
                flight.getDepartureAirport().equals(departureAirport) &&
                flight.getDestinationAirport().equals(destinationAirport) &&
                flight.getDepartureDate().equals(new Flight.Date(day, month, year))) {

                int availableSeatCount = 0;
                for (Seat seat : seats.get(flights.indexOf(flight))) {
                    if (!seat.getStatus()) {
                        availableSeatCount++;
                    }
                }

                str = flight.getFlightNumber() + "@" + flight.getDepartureTime() + "@" + flight.getArrivalTime() + "@" + availableSeatCount;
                break;
            }
        }
        return str;
    }

    public String searchFlightSeatAvailability(String flightID) {
        String str = "";
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equals(flightID)) {
                int availableFClass = 0;
                int availableBClass = 0;
                int availableEClass = 0;
                for (int j = 0; j < seats.get(i).length; j++) {
                    if (!seats.get(i)[j].getStatus()) {
                        if (j < 16) {
                            availableFClass++;
                        } else if (j < 64) {
                            availableBClass++;
                        } else {
                            availableEClass++;
                        }
                    }
                }
                str = availableFClass + "@" + availableBClass + "@" + availableEClass;
                break;
            }
        }
        return str;
    }

    public Seat[] getSeatDetails(String flightID) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equals(flightID)) {
                return seats.get(i);
            }
        }
        return null;
    }

    public String getDeparturedate(String flightID) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightID)) {
                return flight.getDepartureDate().toString();
            }
        }
        return "";
    }

    public Reservation makeReservation(int number, Passenger[] passengers, String flightID, String deptDate, Seat[] seat) {
        reservationNumber++;
        Reservation reserve = new Reservation(reservationNumber, number, passengers, flightID, deptDate, seat);
        reservations.add(reserve);
        return reserve;
    }

    public void cancelReservation(int resNumber) {
        reservations.removeIf(reservation -> reservation.getReservationNumber() == resNumber);
        reservationNumber--;
    }

    public List<Passenger> viewPassengerList(String flightID) {
        List<Passenger> passengers = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getFlightNumber().equals(flightID)) {
                passengers.addAll(List.of(reservation.getPassengersArray()));
            }
        }
        return passengers;
    }
}


    

