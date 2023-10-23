package com.youcode.airafrika.models;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uuid")
    private UUID uuid;
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
    private Flight flight;
    @ManyToOne
    private Client client;

    @ManyToMany
    @JoinTable(name = "reservation_extra",
            joinColumns = @JoinColumn(name = "reservation_uuid"),
            inverseJoinColumns = @JoinColumn(name = "extra_uuid")
    )
    private Set<Extra> extras = new HashSet<>();

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
