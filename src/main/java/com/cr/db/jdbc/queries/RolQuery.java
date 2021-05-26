package com.cr.db.jdbc.queries;

import java.util.Map;

public  class RolQuery {
    public static Map<Object, String> INSERT_ROL = Map.ofEntries(
        Map.entry("QUERY", "INSERT INTO rol VALUES(?,?,?)"),   
        Map.entry(1, "idRol"),
        Map.entry(2, "name"),
        Map.entry(3, "description")
        
    );

    public static Map<Object, String> UPDATE_ROL = Map.ofEntries(
        Map.entry("QUERY", "UPDATE rol SET name=?, description=? WHERE id_rol=?"),
        Map.entry(1, "name"),
        Map.entry(2, "description"),
        Map.entry(3, "idRol")
    );

    public static Map<Object, String> ALL_ROL = Map.ofEntries(
        Map.entry("QUERY", "SELECT * FROM rol"),
        Map.entry(1, "idRol"),
        Map.entry(2, "name"),
        Map.entry(3, "description")
    );
} 
