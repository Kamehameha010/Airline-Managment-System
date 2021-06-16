package com.cr.helper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodHelper<T> implements IMethodHelper<T> {

    @Override
    public Object invokeGetter(T obj, String propertyName)
            throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
        Method getter = pd.getReadMethod();

        return getter.invoke(obj);
    }

    @Override
    public void invokeSetter(T obj, String propertyName, Object propertyValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
        Method setter = pd.getWriteMethod();
        setter.invoke(obj, propertyValue);
    }

}
