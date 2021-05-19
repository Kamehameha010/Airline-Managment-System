package com.cr.services.repository.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.cr.db.IConnection;
import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.model.Employee;
import com.cr.services.repository.IRepositoryServices;

public class EmployeeRepository implements IRepositoryServices<Employee> {

    IConnection _connection;
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String INSERT_QUERY = "INSERT INTO employee VALUES(null,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = """
            UPDATE employee SET name=?, lastname=?, identification=?, username=?, password=?, id_rol=?
            WHERE id_emplpoyee=?
            """;
    private final String GET_ALL_QUERY = "SELECT * FROM employee";
 
    public EmployeeRepository() throws IOException {
        _connection = new MysqlConnection(null);

    }

    @Override
    public void create(Employee model) {

        try {
            conn = _connection.connect();
            pstm = conn.prepareCall(INSERT_QUERY);
            pstm.setString(1, model.getName());
            pstm.setString(2, model.getLastName());
            pstm.setInt(3, model.getIdentification());
            pstm.setString(4, model.getUsername());
            pstm.setString(5, model.getPassword());
            pstm.setInt(6, model.getIdRol());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);

        }
    }

    @Override
    public void update(Employee model) {
        try {
            conn = _connection.connect();
            pstm = conn.prepareStatement(UPDATE_QUERY);
            pstm.setInt(1, model.getIdEmployee());
            pstm.setString(2, model.getName());
            pstm.setString(3, model.getLastName());
            pstm.setInt(4, model.getIdentification());
            pstm.setInt(5, model.getIdEmployee());
            pstm.setString(6, model.getUsername());
            pstm.setString(7, model.getPassword());
            pstm.setInt(8, model.getIdRol());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);

        }
    }

    /*
     * @Override public void delete(int id) { conn = _connection.connect(); try {
     * pstm = conn.prepareStatement(DELETE_QUERY); pstm.setInt(1, id);
     * pstm.executeUpdate(); } catch (SQLException e) {
     * System.err.println(e.getMessage()); } finally { _connection.close(pstm);
     * _connection.close(conn); }
     * 
     * }
     */

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        conn = _connection.connect();

        try {
            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);

            while (rs.next()) {
                var employee = new Employee();
                employee.setIdEmployee(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setIdentification(rs.getInt(4));
                employee.setIdEmployee(rs.getInt(5));
                employee.setUsername(rs.getString(6));
                employee.setPassword(rs.getString(7));
                employee.setIdRol(rs.getInt(8));
                employees.add(employee);
            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
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
