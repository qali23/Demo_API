package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name="address")

public class Address {
    @Id
    @Column(name="address_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressID;

    @Column(name = "address")
    private String address;
    public Address() {
    }

    public Address(int addressID, String address) {
        this.addressID = addressID;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getAddressID() {
        return addressID;
    }
}
