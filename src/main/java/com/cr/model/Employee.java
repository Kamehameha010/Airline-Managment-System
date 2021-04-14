package com.cr.model;

public class Employee extends Person {
    private int idEmployee;
    private String code;
    private String username;
    private String password;

    public Employee() {
        super();
    }

    public Employee(String name, String lastname, int identification, String phoneNumber, TypePerson idType,
            String code, String username, String password) {

        super(name, lastname, identification, phoneNumber, idType);
        this.code = code;
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return String.format("Employee: { %s, id_employee:%d, code:%s, username:%s, password:%s }", super.toString(),
                idEmployee, code, username, password);
    }

}
