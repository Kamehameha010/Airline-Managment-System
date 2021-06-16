package com.cr.services.repository.jdbc;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cr.db.IConnection;
import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.db.jdbc.queries.PlaneQuery;
import com.cr.helper.IQueryHelper;
import com.cr.helper.PreparedStamentHelper;
import com.cr.model.Plane;
import com.cr.services.repository.IRepositoryServices;

public class PlaneRepository implements IRepositoryServices<Plane> {

    private IConnection _connection;
    private Connection conn;
    private PreparedStatement pstm;
    private IQueryHelper<PreparedStatement, Plane> _statementHelper;

    public PlaneRepository() throws IOException {

        _connection = new MysqlConnection(null);
        _statementHelper = new PreparedStamentHelper<>();
    }

    @Override
    public void create(Plane model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, PlaneQuery.INSERT_PLANE);
            pstm.executeUpdate();
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public void update(Plane model) {
        conn = _connection.connect();

        try {
            pstm = _statementHelper.PreparedQuery(conn, model, PlaneQuery.UPDATE_PLANE);
            pstm.executeUpdate();
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public List<Plane> getAll() {
        conn = _connection.connect();
        List<Plane> planes = new ArrayList<>();
        try {
            planes = _statementHelper.ReturnDataQuey(conn, Plane.class, PlaneQuery.ALL_PLANE);
        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IntrospectionException e) {
            System.err.println("error");
        } finally {
            _connection.close(conn);
        }
        return planes;
    }

    @Override
    public Plane find(Predicate<Plane> filter) {
        for (Plane plane : getAll()) {
            if (filter.test(plane)) {
                return plane;
            }
        }
        return null;
    }

}
