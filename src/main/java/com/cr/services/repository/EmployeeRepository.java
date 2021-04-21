package com.cr.services.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cr.db.IConnection;
import com.cr.db.mysql.MysqlConnection;
import com.cr.model.Employee;

public class EmployeeRepository implements IRepositoryServices<Employee> {

    IConnection _connection;
    private Connection conn;
    private CallableStatement cstm;

    public EmployeeRepository() {
        _connection = new MysqlConnection(null);

    }

    @Override
    public void create(Employee model) {

        try {
            conn = _connection.connect();
            cstm = conn.prepareCall("{call sp_add_employee(?,?,?,?,?,?,?,?)}");
            cstm.setString(1, model.getName());
            cstm.setString(2, model.getLastName());
            cstm.setInt(3, model.getIdentification());
            cstm.setString(4, model.getPhoneNumber());
            cstm.setString(5, model.getCode());
            cstm.setString(6, model.getUsername());
            cstm.setString(7, model.getPassword());
            cstm.setString(8, null);
            cstm.execute();

        } catch (SQLException e) {
            System.out.println("insert: " + e.getMessage());
        } finally {
            _connection.close(cstm);
            _connection.close(conn);

        }

    }

    @Override
    public void update(Employee model) {
        try {
            conn = _connection.connect();
            cstm = conn.prepareCall("{call sp_update_employee(?,?,?,?,?,?,?,?)}");
            cstm.setString(1, model.getName());
            cstm.setString(2, model.getLastName());
            cstm.setInt(3, model.getIdentification());
            cstm.setString(4, model.getPhoneNumber());
            cstm.setString(5, model.getCode());
            cstm.setString(6, model.getUsername());
            cstm.setString(7, model.getPassword());
            cstm.setString(8, null);
            cstm.execute();

        } catch (SQLException e) {
            System.out.println("insert: " + e.getMessage());
        } finally {
            _connection.close(cstm);
            _connection.close(conn);

        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Employee find(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Employee> GetAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
