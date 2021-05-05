package com.cr.services.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cr.db.IConnection;
import com.cr.db.mysql.MysqlConnection;
import com.cr.model.Plane;

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
    private final String DELETE_QUERY = "DELETE FROM plane WHERE id_plane = ?";

    public PlaneRepository() {

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
            pstm.setInt(1, model.getId());
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
    public void delete(int id) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(DELETE_QUERY);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            System.err.println("err");
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public Plane find(int id) {
        conn = _connection.connect();
        Plane plane = null;
        try {
            pstm = conn.prepareStatement(FIND_QUERY);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                plane = new Plane();
                plane.setId(rs.getInt(1));
                plane.setCode(rs.getString(2));
                plane.setName(rs.getString(3));
                plane.setCapacity(rs.getInt(4));
            }

        } catch (SQLException e) {
            System.err.println("error");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);
        }
        return plane;
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
                plane.setId(rs.getInt(1));
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

}
