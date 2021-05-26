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

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee: {id_employee:%d, name:%s, lastname:%s, identification:%s, username:%s, password:%s, id_rol:%d }",
                idEmployee, name, lastname, identification, username, password, idRol);
    }

}
