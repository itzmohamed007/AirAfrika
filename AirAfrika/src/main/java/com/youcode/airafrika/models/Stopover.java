package com.youcode.airafrika.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Stopover {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "uuid")
    private String uuid;
    @Basic
    @Column(name = "duration")
    private float duration;
    @Basic
    @Column(name = "city")
    private String city;

    @ManyToMany(mappedBy = "stopovers")
    Set<Flight> flights = new HashSet<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stopover stopover = (Stopover) o;

        if (Float.compare(duration, stopover.duration) != 0) return false;
        if (uuid != null ? !uuid.equals(stopover.uuid) : stopover.uuid != null) return false;
        if (city != null ? !city.equals(stopover.city) : stopover.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (duration != 0.0f ? Float.floatToIntBits(duration) : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
