package com.youcode.airafrika.models;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User {
    @Basic
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}