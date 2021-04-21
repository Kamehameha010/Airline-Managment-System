package com.cr.model;

import java.util.HashMap;
import java.util.Map;

public enum PayMethod {
    Card(1), checked(2);

    private int m_value;

    private PayMethod(int value) {
        this.m_value = value;
    }

    private static Map<Object, Object> map = new HashMap<>();

    static {
        for (var payMethod : PayMethod.values()) {
            map.put(payMethod.m_value, payMethod);
        }
    }

    public static PayMethod valueOf(int payMethod) {
        return (PayMethod) map.get(payMethod);
    }

    public int getValue() {
        return m_value;
    }
}
