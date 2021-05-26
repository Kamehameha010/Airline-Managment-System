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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("Plane: { id_plane:%d, name:%s, code:%s, capacity:%d}", idPlane, name, code, capacity);
    }

}
