package com.cr.model;

public class Passenger extends Person {

    private int idPassenger;
    private int passport;
    private String address;
    private String nationality;
    private int idFlight;

    public Passenger() {
        super();
    }

    public Passenger(String name, String lastname, int identification, String phoneNumber,
            int passport, String address, String nationality, int id_flight) {
        super(name, lastname, identification, phoneNumber);
        this.passport = passport;
        this.address = address;
        this.nationality = nationality;
        this.idFlight = id_flight;
    }

    public int getIdPassenger() {
        return this.idPassenger;
    }

    public Passenger setPassport(int passport) {
        this.passport = passport;
        return this;
    }

    public int getPassport() {
        return this.passport;
    }

    public Passenger setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public Passenger setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getNaitonality() {
        return this.nationality;
    }

    public Passenger setIdFlight(int idFlight) {
        this.idFlight = idFlight;
        return this;
    }

    public int getIdFlight() {
        return this.idFlight;
    }

    @Override
    public String toString() {
        return String.format(
                "Passenger: { %s, id_passenger:%d, address:%s, nationality:%s, passport:%d, id_flight:%d }",
                super.toString(), idPassenger, address, nationality, passport, idFlight);
    }

}
