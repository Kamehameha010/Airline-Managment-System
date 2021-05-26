package com.cr.model;

import java.sql.Date;

public class Flight {
    private int idFlight;
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

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    @Override
    public String toString() {
        return String.format("Flight:{ id_flight:%d, name:%s, code:%s, src:%s, dst:%s, date:%s, id_plane:%d}", idFlight,
                name, code, source, destination, date, idPlane);
    }
}
