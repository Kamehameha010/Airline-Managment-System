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
import com.cr.db.jdbc.queries.EmployeeQuery;
import com.cr.model.Employee;
import com.cr.services.repository.IRepositoryServices;

public class EmployeeRepository implements IRepositoryServices<Employee> {

    private IConnection _connection;
    private IQueryHelper<PreparedStatement, Employee> _statementHelper;

    private Connection conn;
    private PreparedStatement pstm;

    public EmployeeRepository() throws IOException {
        _connection = new MysqlConnection(null);
        _statementHelper = new PreparedStamentHelper<>();
    }

    @Override
    public void create(Employee model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, EmployeeQuery.INSERT_EMPLOYEE);
            pstm.executeUpdate();
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
            System.out.println("insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);

        }
    }

    @Override
    public void update(Employee model) {
        conn = _connection.connect();
        try {
            pstm = _statementHelper.PreparedQuery(conn, model, EmployeeQuery.UPDATE_EMPLOYEE);
            pstm.executeUpdate();
           
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            System.out.println("insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);

        }
    }

    @Override
    public List<Employee> getAll() {
        
        conn = _connection.connect();
        List<Employee> employees = new ArrayList<>();
        try {
            employees = _statementHelper.ReturnDataQuey(conn,Employee.class, EmployeeQuery.ALL_EMPLOYEE);

        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IntrospectionException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(conn);

        }

        return employees;
    }

    @Override
    public Employee find(Predicate<Employee> filter) {
        for (Employee employee : getAll()) {
            if (filter.test(employee)) {
                return employee;
            }
        }
        return null;
    }

}
