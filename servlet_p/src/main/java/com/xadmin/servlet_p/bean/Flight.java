package com.xadmin.servlet_p.bean;

public class Flight {
    private String flightcode;
    private String source_l;
    private String destination_l;
    private String takeoffd;
    private int nbseats;
    private double amount;

    // Constructor
    public Flight(String flightcode, String source_l, String destination_l, String takeoffd, int nbseats, double amount) {
        this.flightcode = flightcode;
        this.source_l = source_l;
        this.destination_l = destination_l;
        this.takeoffd = takeoffd;
        this.nbseats = nbseats;
        this.amount = amount;
    }
    public Flight(String flightcode) {
        this.flightcode = flightcode;

    }
    

    // Getters and Setters
    public String getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(String flightcode) {
        this.flightcode = flightcode;
    }

    public String getSource_l() {
        return source_l;
    }

    public void setSource_l(String source_l) {
        this.source_l = source_l;
    }

    public String getDestination_l() {
        return destination_l;
    }

    public void setDestination_l(String destination_l) {
        this.destination_l = destination_l;
    }

    public String getTakeoffd() {
        return takeoffd;
    }

    public void setTakeoffd(String takeoffd) {
        this.takeoffd = takeoffd;
    }

    public int getNbseats() {
        return nbseats;
    }

    public void setNbseats(int nbseats) {
        this.nbseats = nbseats;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
