package com.cr.model;

public class Employee extends Person {
    private int idEmployee;
    private String code;
    private String username;
    private String password;
    private int idRol;

    public Employee() {
        super();
    }

    public Employee(String name, String lastname, int identification, String phoneNumber, String code, String username,
            String password, int idRol) {

        super(name, lastname, identification, phoneNumber);
        this.code = code;
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }

    public int getIdEmployee() {
        return this.idEmployee;
    }

    public Employee setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return this.code;
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
        return String.format("Employee: { %s, id_employee:%d, code:%s, username:%s, password:%s, id_rol:%d }",
                super.toString(), idEmployee, code, username, password, idRol);
    }

}
