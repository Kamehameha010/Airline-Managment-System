package com.cr.model;

public class Passenger {

    private int idPassenger;
    private String name;
    private String lastname;
    private String email;
    private int passport;
    private String address;
    private String nationality;
    private int idFlight;

    public Passenger() {
        super();
    }

    public Passenger(String name, String lastname, String email, int passport, String address, String nationality,
            int id_flight) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.passport = passport;
        this.address = address;
        this.nationality = nationality;
        this.idFlight = id_flight;
    }

    public Passenger setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
        return this;
    }

    public int getIdPassenger() {
        return this.idPassenger;
    }

    public Passenger setName(String name) {
        this.name = name.toUpperCase();
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Passenger setLastName(String lastname) {
        this.lastname = lastname.toUpperCase();
        return this;
    }

    public String getLastName() {
        return this.lastname;
    }

    /*
     * public String getFullName() { return String.format("%s %s", name, lastname);
     * }
     */

    public Passenger setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return this.email;
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

    public String getNationality() {
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
                "Passenger: { id_passenger:%d, name:%s, lastname:%s, email:%s, address:%s, nationality:%s, passport:%d, id_flight:%d }",
                idPassenger, name, lastname, email, address, nationality, passport, idFlight);
    }

}
