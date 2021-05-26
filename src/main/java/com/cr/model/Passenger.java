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

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    @Override
    public String toString() {
        return String.format(
                "Passenger: { id_passenger:%d, name:%s, lastname:%s, email:%s, address:%s, nationality:%s, passport:%d, id_flight:%d }",
                idPassenger, name, lastname, email, address, nationality, passport, idFlight);
    }

}
