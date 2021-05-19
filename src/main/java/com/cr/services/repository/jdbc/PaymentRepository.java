package com.cr.services.repository.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cr.db.IConnection;
import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.model.Payment;
import com.cr.services.repository.ICreate;
import com.cr.services.repository.IFind;

public class PaymentRepository implements ICreate<Payment>, IFind<Payment> {

    IConnection _connection;
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String INSERT_QUERY = "INSERT INTO oayment VALUES(null,?,?,?,?)";
    private final String GET_ALL_QUERY = "SELECT * FROM payment";

    public PaymentRepository() throws IOException {
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

    private List<Payment> getData() {
        conn = _connection.connect();
        List<Payment> payments = new ArrayList<>();
        try {
            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);
            if (rs.next()) {
                Payment payment = new Payment();
                payment.setIdPayment(rs.getInt(1));
                payment.setIdPassenger(rs.getInt(2));
                payment.setMount(rs.getDouble(3));
                payment.setPayMethod(rs.getInt(4));
                payment.setDate(rs.getDate(5));

                payments.add(payment);

            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
            _connection.close(conn);

        }
        return payments;
    }

    public List<Payment> getAll(Predicate<Payment> filter) {

        List<Payment> payments = getData();

        payments.removeIf(filter.negate());
        return payments;

    }

    @Override
    public Payment find(Predicate<Payment> filter) {

        for (Payment payment : getData()) {
            if (filter.test(payment)) {
                return payment;
            }
        }
        return null;
    }
}
