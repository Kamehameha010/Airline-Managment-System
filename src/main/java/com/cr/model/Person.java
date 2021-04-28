package com.cr.model;

public class Person extends Identity {
    private String name;
    private String lastname;
    private int identification;
    private String phoneNumber;
    

    public Person() {
    }

    public Person(String name, String lastname, int identification, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.phoneNumber = phoneNumber;
        
    }

    public Person setName(String name) {
        this.name = name.toUpperCase();
        return this;

    }

    public String getName() {
        return this.name;
    }

    public Person setLastName(String lastname) {
        this.lastname = lastname.toUpperCase();
        return this;
    }

    public String getLastName() {
        return this.lastname;
    }

    public String getFullName() {
        return String.format("%s %s", name, lastname);
    }

    public Person setIdentification(int identification) {
        this.identification = identification;
        return this;
    }

    public int getIdentification() {
        return this.identification;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    @Override
    public String toString() {
        return String.format("Person: { id:%d, name:%s, lastname:%s, identification:%d, phone_number:%s}",
                getId(), name, lastname, identification, phoneNumber);
    }

}


