package com.cr.db.jdbc.queries;

import java.util.Map;

public class PlaneQuery{

    public final static Map<Object, String> INSERT_PLANE = Map.ofEntries(
        Map.entry("QUERY", "INSERT INTO plane VALUES(?,?,?,?)"),   
        Map.entry(1, "idPlane"),
        Map.entry(2, "code"),
        Map.entry(3, "name"),
        Map.entry(4, "capacity")
    );

    public final static Map<Object, String> UPDATE_PLANE = Map.ofEntries(
        Map.entry("QUERY", "UPDATE plane SET code=?, name=?, capacity=? WHERE id_plane=?"),
        Map.entry(1, "code"),
        Map.entry(2, "name"),
        Map.entry(3, "capacity"),
        Map.entry(4, "idPlane")
    );

    public final static Map<Object, String> ALL_PLANE = Map.ofEntries(
        Map.entry("QUERY", "SELECT * FROM plane"),
        Map.entry(1, "idPlane"),
        Map.entry(2, "code"),
        Map.entry(3, "name"),
        Map.entry(4, "capacity")
    );
}
