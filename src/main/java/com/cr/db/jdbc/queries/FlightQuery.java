package com.cr.db.jdbc.queries;

import java.util.Map;

public class FlightQuery {
    public final static Map<Object, String> INSERT_FLIGHT = Map.ofEntries(
        Map.entry("QUERY", "INSERT INTO flight VALUES(?,?,?,?,?,?,?)"),   
        Map.entry(1, "idFlight"),
        Map.entry(2, "code"),
        Map.entry(3, "name"),
        Map.entry(4, "source"),
        Map.entry(5, "destination"),
        Map.entry(6, "date"),
        Map.entry(7, "idPlane")
    );

    public final static Map<Object, String> UPDATE_FLIGHT = Map.ofEntries(
        Map.entry("QUERY", "UPDATE flight SET code=?, name=?, source=?, destination=?, date=?, id_plane=? WHERE id_flight=?"),
        Map.entry(1, "code"),
        Map.entry(2, "name"),
        Map.entry(3, "source"),
        Map.entry(4, "destination"),
        Map.entry(5, "date"),
        Map.entry(6, "idPlane"),
        Map.entry(7, "idFlight")
    );

    public final static Map<Object, String> ALL_FLIGHT = Map.ofEntries(
        Map.entry("QUERY", "SELECT * FROM flight"),
        Map.entry(1, "idFlight"),
        Map.entry(2, "code"),
        Map.entry(3, "name"),
        Map.entry(4, "source"),
        Map.entry(5, "destination"),
        Map.entry(6, "date"),
        Map.entry(7, "idPlane")
    );
}
