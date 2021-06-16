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
import com.cr.db.jdbc.queries.PaymentQuery;
import com.cr.helper.IQueryHelper;
import com.cr.helper.PreparedStamentHelper;
import com.cr.model.Payment;
import com.cr.services.repository.ICreate;
import com.cr.services.repository.IFind;

public class PaymentRepository implements ICreate<Payment>, IFind<Payment> {

    private IConnection _connection;
    private IQueryHelper<PreparedStatement, Payment> _statementHelper;
    private Connection conn;
    private PreparedStatement pstm;

    public PaymentRepository() throws IOException {
        _connection = new MysqlConnection(null);
        _statementHelper = new PreparedStamentHelper<>();
    }

    @Override
    public void create(Payment model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, PaymentQuery.INSERT_PAYMENT);
            pstm.executeUpdate();

        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
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
            payments = _statementHelper.ReturnDataQuey(conn, Payment.class, PaymentQuery.ALL_PAYMENT);

        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IntrospectionException e) {

            System.err.println("Error Find");
        } finally {
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
