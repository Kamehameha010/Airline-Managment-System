package com.cr.services.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cr.db.IConnection;
import com.cr.db.mysql.MysqlConnection;
import com.cr.model.Payment;

public class PaymentRepository implements ICreate<Payment>, IFind<Payment> {

    IConnection _connection;
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String INSERT_QUERY = "INSERT INTO oayment VALUES(null,?,?,?,?)";
    private final String FIND_QUERY = "SELECT * FROM payment WHERE id_passenger=?";

    public PaymentRepository() {
        _connection = new MysqlConnection(null);
    }

    @Override
    public void create(Payment model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(INSERT_QUERY);
            pstm.setInt(1, model.getIdPassenger());
            pstm.setDouble(2, model.getMount());
            pstm.setInt(3, model.getPayMethod().getValue());
            pstm.setDate(4, (Date) model.getDate());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }

    }

    @Override
    public Payment find(int id) {
        conn = _connection.connect();
        Payment payment = null;
        try {
            pstm = conn.prepareStatement(FIND_QUERY);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setId(rs.getInt(1));
                payment.setIdPassenger(rs.getInt(2));
                payment.setMount(rs.getDouble(3));
                payment.setPayMethod(rs.getInt(4));
                payment.setDate(rs.getDate(5));
            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);

        }
        return payment;
    }
}
