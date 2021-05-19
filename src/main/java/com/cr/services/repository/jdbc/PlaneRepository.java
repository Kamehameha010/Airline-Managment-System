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
import com.cr.model.Plane;
import com.cr.services.repository.IRepositoryServices;

public class PlaneRepository implements IRepositoryServices<Plane> {

    IConnection _connection;
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String INSERT_QUERY = "INSERT INTO plane VALUES(null,?,?,?)";
    private final String UPDATE_QUERY = """
            UPDATE plane SET code=?, name=?, capacity=?
            WHERE id_plane=?
            """;
    private final String FIND_QUERY = """
            SELECT * FROM plane WHERE id_plane=?
            """;
    private final String GET_ALL_QUERY = "SELECT * FROM plane";

    public PlaneRepository() throws IOException {

        _connection = new MysqlConnection(null);
    }

    @Override
    public void create(Plane model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(INSERT_QUERY);
            pstm.setString(1, model.getCode());
            pstm.setString(2, model.getName());
            pstm.setInt(3, model.getCapacity());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public void update(Plane model) {
        conn = _connection.connect();

        try {
            pstm = conn.prepareStatement(UPDATE_QUERY);
            pstm.setInt(1, model.getIdPlane());
            pstm.setString(2, model.getCode());
            pstm.setString(3, model.getName());
            pstm.setInt(4, model.getCapacity());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public List<Plane> getAll() {
        conn = _connection.connect();
        List<Plane> planes = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(GET_ALL_QUERY);
            rs = pstm.executeQuery();
            while (rs.next()) {
                var plane = new Plane();
                plane.setIdPlane(rs.getInt(1));
                plane.setCode(rs.getString(2));
                plane.setName(rs.getString(3));
                plane.setCapacity(rs.getInt(4));
                planes.add(plane);
            }
        } catch (SQLException e) {
            System.err.println("error");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);
        }
        return planes;
    }

    @Override
    public Plane find(Predicate<Plane> filter) {
        for (Plane plane : getAll()) {
            if (filter.test(plane)) {
                return plane;
            }
        }
        return null;
    }

}
