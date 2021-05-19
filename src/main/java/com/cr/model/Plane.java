package com.cr.model;

public class Plane {
    private int idPlane;
    private String code;
    private String name;
    private int capacity;

    public Plane() {

    }

    public Plane(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public Plane setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public Plane setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Plane setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return String.format("Plane: { id_plane:%d, name:%s, code:%s, capacity:%d}", idPlane, name, code, capacity);
    }

}
