package com.cr.db.jdbc.queries;

import java.util.Map;

public class PassengerQuery {
    public final static Map<Object, String> INSERT_PASSENGER = Map.ofEntries(
        Map.entry("QUERY", "INSERT INTO passenger VALUES (?,?,?,?,?,?,?,?)"),   
        Map.entry(1, "idPassenger"),
        Map.entry(2, "name"),
        Map.entry(3, "lastname"),
        Map.entry(4, "email"),
        Map.entry(5, "passport"),
        Map.entry(6, "address"),
        Map.entry(7, "nationality"),
        Map.entry(8, "idFlight")
    );

    public final static Map<Object, String> UPDATE_PASSENGER = Map.ofEntries(
        Map.entry("QUERY", "UPFATE passenger SET name=?, lastname=?, email=?, passport=?, address=?, nationality=?, id_flight=? WHERE id_passenger=?"),
        Map.entry(1, "name"),
        Map.entry(2, "lastname"),
        Map.entry(3, "email"),
        Map.entry(4, "passport"),
        Map.entry(5, "address"),
        Map.entry(6, "nationality"),
        Map.entry(7, "idFlight"),
        Map.entry(8, "idPassenger")
    );

    public final static Map<Object, String> ALL_PASSENGER = Map.ofEntries(
        Map.entry("QUERY", "SELECT * FROM passenger"),
        Map.entry(1, "idPassenger"),
        Map.entry(2, "name"),
        Map.entry(3, "lastname"),
        Map.entry(4, "email"),
        Map.entry(5, "passport"),
        Map.entry(6, "address"),
        Map.entry(7, "nationality"),
        Map.entry(8, "idFlight")
    );
}
