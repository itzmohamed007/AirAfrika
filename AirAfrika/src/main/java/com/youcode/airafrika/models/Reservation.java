package com.youcode.airafrika.models;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uuid")
    private String uuid;
    @Basic
    @Column(name = "date")
    private LocalTime date;
    @Basic
    @Column(name = "status")
    private ReservationStatus status;
    @Basic
    @Column(name = "seats_number")
    private int seatsNumber;
    @ManyToOne
    @Column(name = "flight_id")
    private Flight flight;
    @ManyToOne
    @Column(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "reservation_extra",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id")
    )
    private Set<Extra> extras = new HashSet<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Object getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}