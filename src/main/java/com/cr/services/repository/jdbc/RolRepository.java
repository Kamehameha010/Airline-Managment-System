package com.cr.services.repository.jdbc;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cr.db.IConnection;
import com.cr.db.jdbc.helper.IQueryHelper;
import com.cr.db.jdbc.helper.PreparedStamentHelper;
import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.db.jdbc.queries.RolQuery;
import com.cr.model.Rol;
import com.cr.services.repository.IRepositoryServices;

public class RolRepository implements IRepositoryServices<Rol> {

    private IConnection _connection;
    private Connection conn;
    private PreparedStatement pstm;

    private IQueryHelper<PreparedStatement,Rol> _statementHelper;

    public RolRepository() throws IOException {
        _connection = new MysqlConnection(null);
        _statementHelper = new PreparedStamentHelper<>();
    }

    @Override
    public void create(Rol model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, RolQuery.INSERT_ROL);
            pstm.executeUpdate();

        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public void update(Rol model) {
        conn = _connection.connect();
        try {
            pstm =_statementHelper.PreparedQuery(conn, model, RolQuery.UPDATE_ROL);
            pstm.executeUpdate();

        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }

    }

    public List<Rol> getAll() {
        conn = _connection.connect();
        List<Rol> roles = new ArrayList<>();
        try {

           roles = _statementHelper.ReturnDataQuey(conn, Rol.class, RolQuery.ALL_ROL);

        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IntrospectionException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(conn);
        }

        return roles;
    }

    @Override
    public Rol find(Predicate<Rol> filter) {
        for (Rol rol : getAll()) {
            if (filter.test(rol)) {
                return rol;
            }
        }
        return null;
    }


}
