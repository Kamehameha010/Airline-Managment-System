package com.cr.model;

public class Rol extends Identity {

    private String name;
    private String description;

    public Rol() {
    }

    public Rol(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Rol setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Rol setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return String.format("Rol: {id_rol:%d, name:%s, description:%s}", getId(), name, description);
    }

}
