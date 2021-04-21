package com.cr.model;

import java.sql.Date;

public class Flight extends Identity {
    private String code;
    private String name;
    private String source;
    private String destination;
    private Date date;
    private int idPlane;

    public Flight() {
    }

    public Flight(String code, String name, String source, String destination, Date date, int idPlane) {
        this.code = code;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.idPlane = idPlane;
    }

    public Flight setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public Flight setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Flight setSource(String source) {
        this.source = source;
        return this;
    }

    public String getSource() {
        return this.source;
    }

    public Flight setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public String getDestination() {
        return this.destination;
    }

    public Flight setDate(Date date) {
        this.date = date;
        return this;
    }

    public Date getDate() {
        return this.date;
    }

    public Flight setIdPlane(int idPlane) {
        this.idPlane = idPlane;
        return this;
    }

    public int getIdPlane() {
        return this.idPlane;
    }

    @Override
    public String toString() {
        return String.format("Flight:{ id_flight:%d, name:%s, code:%s, src:%s, dst:%s, date:%s, id_plane:%d}", getId(),
                name, code, source, destination, date, idPlane);
    }
}
