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
import com.cr.db.jdbc.helper.IQueryHelper;
import com.cr.db.jdbc.helper.PreparedStamentHelper;
import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.db.jdbc.queries.FlightQuery;
import com.cr.model.Flight;
import com.cr.services.repository.IRepositoryServices;

public class FlightRepository implements IRepositoryServices<Flight> {
    private IConnection _connection;
    private IQueryHelper<PreparedStatement, Flight> _statementHelper;

    private Connection conn;
    private PreparedStatement pstm;

    public FlightRepository() throws IOException {
        _connection = new MysqlConnection(null);
        _statementHelper = new PreparedStamentHelper<>();
    }

    @Override
    public void create(Flight model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, FlightQuery.INSERT_FLIGHT);
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
    public void update(Flight model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, FlightQuery.UPDATE_FLIGHT);
            pstm.executeUpdate();
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    public List<Flight> getAll() {
        conn = _connection.connect();
        List<Flight> flights = new ArrayList<>();
        try {
            flights = _statementHelper.ReturnDataQuey(conn, Flight.class, FlightQuery.ALL_FLIGHT);

        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException | IntrospectionException e) {
            System.err.println("Error");
        } finally {

            _connection.close(conn);
        }

        return flights;
    }

    @Override
    public Flight find(Predicate<Flight> filter) {
        for (Flight flight : getAll()) {
            if (filter.test(flight)) {
                return flight;
            }
        }
        return null;
    }
}
