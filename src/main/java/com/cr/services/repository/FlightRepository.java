package com.cr.services.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cr.db.IConnection;
import com.cr.db.mysql.MysqlConnection;
import com.cr.model.Flight;

public class FlightRepository implements ICreate<Flight>, IUpdate<Flight>, IFind<Flight> {
    IConnection _connection;
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String ADD_QUERY = "INSERT INTO flight VALUES(null,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = """
            UPDATE flight SET code=?, name=?, source=?, destination=?, date=?,
            id_plane=?
            WHERE id_flight=?
            """;
    private final String FIND_QUERY = """
            SELECT * FROM flight WHERE id_flight=?
            """;
    private final String GET_ALL_QUERY = "SELECT * FROM flight";

    public FlightRepository() {
        _connection = new MysqlConnection(null);

    }

    @Override
    public Flight find(int id) {
        conn = _connection.connect();
        Flight flight = null;
        try {
            pstm = conn.prepareStatement(FIND_QUERY);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flight = new Flight();
                flight.setId(rs.getInt(1));
                flight.setCode(rs.getString(2));
                flight.setSource(rs.getString(3));
                flight.setDestination(rs.getString(4));
                flight.setDate(rs.getDate(5));
                flight.setIdPlane(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.err.println("Error");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);
        }

        return flight;
    }

    @Override
    public void update(Flight model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(UPDATE_QUERY);
            pstm.setString(1, model.getCode());
            pstm.setString(2, model.getName());
            pstm.setString(3, model.getSource());
            pstm.setString(4, model.getDestination());
            pstm.setDate(5, model.getDate());
            pstm.setInt(6, model.getIdPlane());
            pstm.setInt(4, model.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public void create(Flight model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(ADD_QUERY);
            pstm.setString(1, model.getCode());
            pstm.setString(2, model.getName());
            pstm.setString(3, model.getSource());
            pstm.setString(4, model.getDestination());
            pstm.setDate(5, model.getDate());
            pstm.setInt(6, model.getIdPlane());
            pstm.executeUpdate();
        } catch (SQLException e) {
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
            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt(1));
                flight.setCode(rs.getString(2));
                flight.setSource(rs.getString(3));
                flight.setDestination(rs.getString(4));
                flight.setDate(rs.getDate(5));
                flight.setIdPlane(rs.getInt(6));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);
        }

        return flights;
    }
}
