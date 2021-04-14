package com.cr.model;

public class Person extends Identity {
    private String name;
    private String lastname;
    private int identification;
    private String phoneNumber;
    private TypePerson idType;

    public Person() {
    }

    public Person(String name, String lastname, int identification, String phoneNumber, TypePerson idType) {
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.phoneNumber = phoneNumber;
        this.idType = idType;
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

    public String getPhoneNumber(String phoneNumber) {
        return this.phoneNumber;
    }

    public Person setidType(int idType) {
        this.idType = TypePerson.valueOf(idType);
        return this;
    }

    public TypePerson getIdType() {
        return this.idType;
    }

    @Override
    public String toString() {
        return String.format("Person: { id:%d, name:%s, lastname:%s, identification:%d, phone_number:%s, id_type:%s}",
                getId(), name, lastname, identification, phoneNumber, idType);
    }

}
