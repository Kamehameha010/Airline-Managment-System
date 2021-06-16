package com.cr.helper;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public interface IMethodHelper <T> {
    
    Object invokeGetter(T obj, String propertyName) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
    void invokeSetter(T obj, String propertyName, Object propertyValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException;
}
