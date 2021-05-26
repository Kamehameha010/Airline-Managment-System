package com.cr.db.jdbc.queries;

import java.util.Map;

public class PaymentQuery {
    public final static Map<Object, String> INSERT_PAYMENT = Map.ofEntries(
        Map.entry("QUERY", "INSERT INTO oayment VALUES(?,?,?,?,?)"),   
        Map.entry(1, "idPayment"),
        Map.entry(2, "idPassenger"),
        Map.entry(3, "mount"),
        Map.entry(4, "payMethod"),
        Map.entry(5, "date")
    );

    public final static Map<Object, String> ALL_PAYMENT = Map.ofEntries(
        Map.entry("QUERY", "SELECT * FROM payment"),
        Map.entry(1, "idPayment"),
        Map.entry(2, "idPassenger"),
        Map.entry(3, "mount"),
        Map.entry(4, "payMethod"),
        Map.entry(5, "date")
    );
}
