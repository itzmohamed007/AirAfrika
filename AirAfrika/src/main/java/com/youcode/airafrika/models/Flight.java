package com.youcode.airafrika.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Flight {
    @Id
    @Column(name = "uuid")
    @GeneratedValue
    private UUID uuid;
    @Basic
    @Column(name = "departure_city")
    private String departureCity;
    @Basic
    @Column(name = "arrival_city")
    private String arrivalCity;
    @Basic
    @Column(name = "departure_date")
    private LocalDate departureDate;
    @Basic
    @Column(name = "arrival_date")
    private LocalDate arrivalDate;
    @Basic
    @Column(name = "departure_time")
    private LocalTime departureTime;
    @Basic
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
    @Basic
    @Column(name = "seats_number")
    private int seatsNumber;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(name = "stopover_flight",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "stopover_id")
    )
    private Set<Stopover> stopovers = new HashSet<>();

    @Override
    public String toString() {
        return "Flight{" +
                "uuid=" + uuid +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", seatsNumber=" + seatsNumber +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stopovers=" + stopovers +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void copyFlight(Flight original, Flight updated) {
        updated.setDepartureCity(original.getDepartureCity());
        updated.setArrivalCity(original.getArrivalCity());
        updated.setDepartureDate(original.getDepartureDate());
        updated.setArrivalDate(original.getArrivalDate());
        updated.setDepartureTime(original.getDepartureTime());
        updated.setArrivalTime(original.getArrivalTime());
        updated.setSeatsNumber(original.getSeatsNumber());
        updated.setDescription(original.getDescription());
        updated.setPrice(original.getPrice());
    }
}

