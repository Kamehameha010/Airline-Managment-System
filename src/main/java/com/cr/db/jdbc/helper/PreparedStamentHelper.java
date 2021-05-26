package com.cr.db.jdbc.helper;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreparedStamentHelper<T> implements IQueryHelper<PreparedStatement, T> {

    private IMethodHelper<T> _methodHelper;

    public PreparedStamentHelper() {
        _methodHelper = new MethodHelper<T>();
    }

    @Override
    public PreparedStatement PreparedQuery(Connection connection, T obj, Map<Object, String> params)
            throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            IntrospectionException {

        PreparedStatement pstm = connection.prepareStatement(params.get("QUERY"));
        var map = new MapHelper<Integer, String>().filterMap(params);
        for (var entry : map.entrySet()) {
            pstm.setObject(entry.getKey(), _methodHelper.invokeGetter(obj, entry.getValue()));
        }
        return pstm;

    }

    @Override
    public List<T> ReturnDataQuey(Connection connection, Class<T> obj, Map<Object, String> params)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, SQLException, IntrospectionException {

        ResultSet rs = connection.createStatement().executeQuery(params.get("QUERY"));
        var nMap = new MapHelper<Integer, String>().filterMap(params);

        List<T> list = new ArrayList<>();
        while (rs.next()) {
            var cls = obj.getDeclaredConstructor().newInstance();
            for (var entry : nMap.entrySet()) {
                _methodHelper.invokeSetter(cls, entry.getValue(), rs.getObject(entry.getKey()));
            }
            list.add(cls);
        }
        return list;
    }

}
