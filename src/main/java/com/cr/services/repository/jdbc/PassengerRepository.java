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
import com.cr.db.jdbc.queries.PassengerQuery;
import com.cr.helper.IQueryHelper;
import com.cr.helper.PreparedStamentHelper;
import com.cr.model.Passenger;
import com.cr.services.repository.IRepositoryServices;

public class PassengerRepository implements IRepositoryServices<Passenger> {

    private IConnection _connection;
    private IQueryHelper<PreparedStatement, Passenger> _statementHelper;

    private Connection conn;
    private PreparedStatement pstm;
    

    public PassengerRepository() throws IOException {
        _connection = new MysqlConnection(null);
        _statementHelper = new PreparedStamentHelper<>();
    }

    @Override
    public void create(Passenger model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, PassengerQuery.INSERT_PASSENGER);
            pstm.executeUpdate();

        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public void update(Passenger model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, PassengerQuery.UPDATE_PASSENGER);
            pstm.executeUpdate();

        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }

    }

    public List<Passenger> getAll() {
        conn = _connection.connect();
        List<Passenger> passengers = new ArrayList<>();
        try {

            passengers = _statementHelper.ReturnDataQuey(conn, Passenger.class, PassengerQuery.ALL_PASSENGER);

        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IntrospectionException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(conn);

        }

        return passengers;
    }

    @Override
    public Passenger find(Predicate<Passenger> filter) {
        for (Passenger passenger : getAll()) {
            if (filter.test(passenger)) {
                return passenger;
            }
        }
        return null;
    }

}
