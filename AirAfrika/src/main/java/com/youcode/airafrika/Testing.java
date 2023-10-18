package com.youcode.airafrika;

import com.youcode.airafrika.models.Flight;
import com.youcode.airafrika.services.FlightService;

import java.util.List;

public class Testing {
    // Created for testing
    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.getAll();
        for(Flight flight : flights) {
            System.out.println("flight uuid: " + flight.getUuid());
            System.out.println("flight departure city: " + flight.getDepartureCity());
            System.out.println("flight arrival city: " + flight.getArrivalCity());
            System.out.println("flight departure date: " + flight.getDepartureDate());
            System.out.println("flight arrival date: " + flight.getDepartureDate());
            System.out.println("flight departure time: " + flight.getDepartureTime());
            System.out.println("flight arrival time: " + flight.getArrivalTime());
            System.out.println("flight seats number: " + flight.getSeatsNumber());
            System.out.println("flight price: " + flight.getPrice());
            System.out.println("flight description: " + flight.getDescription());
        }
    }

}
