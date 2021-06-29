package com.cr.services.validation.data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DataValidation {

    public static Object verifyObject(Object value) {
        if(value instanceof LocalDateTime){
            return Date.from(((LocalDateTime) value).atZone(ZoneId.systemDefault()).toInstant());
        }
        return value;
    }
}
