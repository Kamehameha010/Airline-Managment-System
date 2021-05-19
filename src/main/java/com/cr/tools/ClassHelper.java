package com.cr.tools;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassHelper<T> {
    public static <T> void invokeGetter(T obj, String propertyName)
            throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
        Method getter = pd.getReadMethod();
        Object f = getter.invoke(obj);
        System.out.println(f);
    }

    public static <T> void invokeSetter(T obj, String propertyName, Object value)
            throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        var pd = new PropertyDescriptor(propertyName, obj.getClass());
        Method setter = pd.getWriteMethod();
        setter.invoke(obj, value);
    }
}
