package com.xadmin.servlet_p.bean;

public class tickets {

    private int ticketId;
    private String pName;
    private Flight flCode;
    private String pGen;
    private String pPass;
    private int amount;
    private String nationality;

    // Constructor
    public tickets(int ticketId, String pName, Flight flCode, String pGen, String pPass, int amount, String nationality) {
        this.ticketId = ticketId;
        this.pName = pName;
        this.flCode = flCode;
        this.pGen = pGen;
        this.pPass = pPass;
        this.amount = amount;
        this.nationality = nationality;
    }

    // Getters
    public int getTicketId() {
        return ticketId;
    }

    public String getPName() {
        return pName;
    }

    public Flight getFlCode() {
        return flCode;
    }

    public String getPGen() {
        return pGen;
    }

    public String getPPass() {
        return pPass;
    }

    public int getAmount() {
        return amount;
    }

    public String getNationality() {
        return nationality;
    }
}
