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
import com.cr.model.Employee;

public class EmployeeRepository implements IRepositoryServices<Employee> {

    IConnection _connection;
    private Connection conn;
    private CallableStatement cstm;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String ADD_QUERY = "{call sp_add_employee(?,?,?,?,?,?,?,?)}";
    private final String UPDATE_QUERY = "{call sp_update_employee(?,?,?,?,?,?,?,?,?,?)}";
    private final String FIND_QUERY = """
            SELECT p.id_person, p.name, p.lastname, p.identification, p.phone_number,
                e.id_employee, e.code, e.username, e.password, e.id_rol
            FROM person as p
            INNER JOIN employee as e on p.id_person = e.id_person
            WHERE id_employee=?
            """;
    private final String GET_ALL_QUERY = "SELECT * FROM employee_view";
    // TODO change query
    private final String DELETE_QUERY = "DELETE FROM employee WHERE id_employee=?";// change by state

    public EmployeeRepository() {
        _connection = new MysqlConnection(null);

    }

    @Override
    public void create(Employee model) {

        try {
            conn = _connection.connect();
            cstm = conn.prepareCall(ADD_QUERY);
            cstm.setString(1, model.getName());
            cstm.setString(2, model.getLastName());
            cstm.setInt(3, model.getIdentification());
            cstm.setString(4, model.getPhoneNumber());
            cstm.setString(5, model.getCode());
            cstm.setString(6, model.getUsername());
            cstm.setString(7, model.getPassword());
            cstm.setInt(8, model.getIdRol());
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
            cstm = conn.prepareCall(UPDATE_QUERY);
            cstm.setInt(1, model.getId());
            cstm.setString(2, model.getName());
            cstm.setString(3, model.getLastName());
            cstm.setInt(4, model.getIdentification());
            cstm.setString(5, model.getPhoneNumber());
            cstm.setInt(6, model.getIdEmployee());
            cstm.setString(6, model.getCode());
            cstm.setString(7, model.getUsername());
            cstm.setString(8, model.getPassword());
            cstm.setInt(9, model.getIdRol());

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
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(DELETE_QUERY);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }

    }

    @Override
    public Employee find(int id) {
        conn = _connection.connect();
        Employee employee = null;
        try {
            pstm = conn.prepareStatement(FIND_QUERY);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setIdentification(rs.getInt(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setIdEmployee(rs.getInt(6));
                employee.setCode(rs.getString(7));
                employee.setUsername(rs.getString(8));
                employee.setPassword(rs.getString(9));
                employee.setIdRol(rs.getInt(10));
            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);

        }

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        conn = _connection.connect();

        try {
            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);

            while (rs.next()) {
                var employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setIdentification(rs.getInt(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setIdEmployee(rs.getInt(6));
                employee.setCode(rs.getString(7));
                employee.setUsername(rs.getString(8));
                employee.setPassword(rs.getString(9));
                employee.setIdRol(rs.getInt(10));
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

}
