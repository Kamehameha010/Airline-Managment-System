package com.cr.model;

public class Employee {
    private int idEmployee;
    private String name;
    private String lastname;
    private int identification;
    private String username;
    private String password;
    private int idRol;

    public Employee() {
        super();
    }

    public Employee(String name, String lastname, int identification, String username, String password, int idRol) {

        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }

    public Employee setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
        return this;
    }

    public int getIdEmployee() {
        return this.idEmployee;
    }

    public Employee setName(String name) {
        this.name = name.toUpperCase();
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Employee setLastName(String lastname) {
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

    public Employee setIdentification(int identification) {
        this.identification = identification;
        return this;
    }

    public int getIdentification() {
        return this.identification;
    }

    public Employee setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public Employee setIdRol(int idRol) {
        this.idRol = idRol;
        return this;
    }

    public int getIdRol() {
        return idRol;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee: {id_employee:%d, name:%s, lastname:%s, identification:%s, username:%s, password:%s, id_rol:%d }",
                idEmployee, name, lastname, identification, username, password, idRol);
    }

}
