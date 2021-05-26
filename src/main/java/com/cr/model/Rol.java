package com.cr.model;

public class Rol {

    private int idRol;
    private String name;
    private String description;

    public Rol() {
    }

    public Rol(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Rol: {id_rol:%d, name:%s, description:%s}", idRol, name, description);
    }

}
