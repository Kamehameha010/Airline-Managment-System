package com.cr.services.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cr.db.IConnection;
import com.cr.db.mysql.MysqlConnection;
import com.cr.model.Passenger;

public class PassengerRepository implements ICreate<Passenger>, IUpdate<Passenger>, IFind<Passenger> {

    IConnection _connection;
    private Connection conn;
    private CallableStatement cstm;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String ADD_QUERY = "{call sp_add_passenger(?,?,?,?,?,?,?,?)}";
    private final String UPDATE_QUERY = "{call sp_update_passenger(?,?,?,?,?,?,?,?,?,?)}";
    private final String FIND_QUERY = """
            SELECT p.id_person, p.name, p.lastname, p.identification, p.phone_number,
                e.id_passenger, e.passport, e.address, e.nationality, e.id_flight
            FROM person as p
            INNER JOIN passenger as e on p.id_person = e.id_person
            WHERE id_passenger=?
            """;
    private final String GET_ALL_QUERY = "SELECT * FROM employee_view";

    public PassengerRepository() {
        _connection = new MysqlConnection(null);
    }

    @Override
    public void create(Passenger model) {
        conn = _connection.connect();
        try {
            cstm = conn.prepareCall(ADD_QUERY);
            cstm.setString(1, model.getName());
            cstm.setString(2, model.getLastName());
            cstm.setInt(3, model.getIdentification());
            cstm.setString(4, model.getPhoneNumber());
            cstm.setInt(5, model.getPassport());
            cstm.setString(6, model.getAddress());
            cstm.setString(7, model.getNationality());
            cstm.setInt(8, model.getIdFlight());
            cstm.execute();

        } catch (SQLException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(cstm);
            _connection.close(conn);
        }
    }

    @Override
    public void update(Passenger model) {
        conn = _connection.connect();
        try {
            cstm = conn.prepareCall(UPDATE_QUERY);
            cstm.setInt(1, model.getId());
            cstm.setString(2, model.getName());
            cstm.setString(3, model.getLastName());
            cstm.setInt(4, model.getIdentification());
            cstm.setString(5, model.getPhoneNumber());
            cstm.setInt(6, model.getIdPassenger());
            cstm.setInt(7, model.getPassport());
            cstm.setString(8, model.getAddress());
            cstm.setString(9, model.getNationality());
            cstm.setInt(10, model.getIdFlight());
            cstm.execute();

        } catch (SQLException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(cstm);
            _connection.close(conn);
        }

    }

    @Override
    public Passenger find(int id) {

        conn = _connection.connect();
        Passenger passenger = null;
        try {
            pstm = conn.prepareStatement(FIND_QUERY);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();
            if (rs.next()) {
                passenger = new Passenger();
                passenger.setId(rs.getInt(1));
                passenger.setName(rs.getString(2));
                passenger.setLastName(rs.getString(3));
                passenger.setIdentification(rs.getInt(4));
                passenger.setPhoneNumber(rs.getString(5));
                passenger.setIdPassenger(rs.getInt(6));
                passenger.setPassport(rs.getInt(7));
                passenger.setAddress(rs.getString(8));
                passenger.setNationality(rs.getString(9));
                passenger.setIdFlight(rs.getInt(10));
            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);

        }

        return passenger;
    }

    public List<Passenger> getAll() {
        conn = _connection.connect();
        List<Passenger> passengers = new ArrayList<>();
        try {

            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);
            if (rs.next()) {
                var passenger = new Passenger();
                passenger.setId(rs.getInt(1));
                passenger.setName(rs.getString(2));
                passenger.setLastName(rs.getString(3));
                passenger.setIdentification(rs.getInt(4));
                passenger.setPhoneNumber(rs.getString(5));
                passenger.setIdPassenger(rs.getInt(6));
                passenger.setPassport(rs.getInt(7));
                passenger.setAddress(rs.getString(8));
                passenger.setNationality(rs.getString(9));
                passenger.setIdFlight(rs.getInt(10));
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

}
