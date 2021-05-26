package com.cr.db.jdbc.helper;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public interface IQueryHelper<T extends Statement, U extends Object> {

    T PreparedQuery(Connection connection, U obj, Map<Object, String> params) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException;

    List<U> ReturnDataQuey(Connection connection, Class<U> obj, Map<Object,String> params) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, IntrospectionException;
}
