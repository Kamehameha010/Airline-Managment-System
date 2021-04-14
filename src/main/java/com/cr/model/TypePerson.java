package com.cr.model;

import java.util.HashMap;
import java.util.Map;

public enum TypePerson {

    PASSENGER(1), EMPLOYEE(2);

    private int m_value;

    private TypePerson(int value) {
        this.m_value = value;
    }

    private static Map map = new HashMap<>();

    static {
        for (var typePerson : TypePerson.values()) {
            map.put(typePerson.m_value, typePerson);
        }
    }

    public static TypePerson valueOf(int typePerson) 
    {
        return (TypePerson)map.get(typePerson);
    }

    public int getValue() {
        return m_value;
    }

}
