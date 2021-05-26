package com.cr.db.jdbc.queries;

import java.util.Map;

public class EmployeeQuery {
    public final static Map<Object, String> INSERT_EMPLOYEE = Map.ofEntries(
        Map.entry("QUERY", "INSERT INTO employee VALUES(?,?,?,?,?,?,?)"),   
        Map.entry(1, "idEmployee"),
        Map.entry(2, "name"),
        Map.entry(3, "lastname"),
        Map.entry(4, "identification"),
        Map.entry(5, "username"),
        Map.entry(6, "password"),
        Map.entry(7, "idRol")
    );

    public final static Map<Object, String> UPDATE_EMPLOYEE = Map.ofEntries(
        Map.entry("QUERY", "UPDATE employee SET name=?, lastname=?, identification=?, username=?, password=?, id_rol=? WHERE id_emplpoyee=?"),
        Map.entry(1, "name"),
        Map.entry(2, "lastname"),
        Map.entry(3, "identification"),
        Map.entry(4, "username"),
        Map.entry(5, "password"),
        Map.entry(6, "idRol"),
        Map.entry(7, "idEmployee")
    );

    public final static Map<Object, String> ALL_EMPLOYEE = Map.ofEntries(
        Map.entry("QUERY", "SELECT * FROM employee"),
        Map.entry(1, "idEmployee"),
        Map.entry(2, "name"),
        Map.entry(3, "lastname"),
        Map.entry(4, "identification"),
        Map.entry(5, "username"),
        Map.entry(6, "password"),
        Map.entry(7, "idRol")
    );
}
