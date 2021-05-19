package com.cr.services.repository.jdbc;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cr.db.IConnection;
import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.model.Passenger;
import com.cr.services.repository.ICreate;
import com.cr.services.repository.IFind;
import com.cr.services.repository.IRepositoryServices;
import com.cr.services.repository.IUpdate;

public class PassengerRepository implements IRepositoryServices<Passenger> {

    IConnection _connection;
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String INSERT_QUERY = "INSERT INTO passenger VALUES (null,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = """
            UPFATE passenger SET name=?, lastname=?, email=?, passport=?, address=?, nationality=?,
            id_flight=?
            WHERE id_passenger=?
            """;

    private final String GET_ALL_QUERY = "SELECT * FROM employee_view";

    public PassengerRepository() throws IOException {
        _connection = new MysqlConnection(null);
    }

    @Override
    public void create(Passenger model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(INSERT_QUERY);
            pstm.setString(1, model.getName());
            pstm.setString(2, model.getLastName());
            pstm.setString(3, model.getEmail());
            pstm.setInt(4, model.getPassport());
            pstm.setString(5, model.getAddress());
            pstm.setString(6, model.getNationality());
            pstm.setInt(7, model.getIdFlight());
            pstm.executeUpdate();

        } catch (SQLException e) {
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
            pstm = conn.prepareStatement(UPDATE_QUERY);
            pstm.setInt(1, model.getIdPassenger());
            pstm.setString(2, model.getName());
            pstm.setString(3, model.getLastName());
            pstm.setString(4, model.getEmail());
            pstm.setInt(5, model.getPassport());
            pstm.setString(6, model.getAddress());
            pstm.setString(7, model.getNationality());
            pstm.setInt(8, model.getIdFlight());
            pstm.executeUpdate();

        } catch (SQLException e) {
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

            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);
            if (rs.next()) {
                var passenger = new Passenger();
                passenger.setIdPassenger(rs.getInt(1));
                passenger.setName(rs.getString(2));
                passenger.setLastName(rs.getString(3));
                passenger.setEmail(rs.getString(4));
                passenger.setPassport(rs.getInt(5));
                passenger.setAddress(rs.getString(6));
                passenger.setNationality(rs.getString(7));
                passenger.setIdFlight(rs.getInt(8));
                passengers.add(passenger);
            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
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
