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
import com.cr.model.Rol;
import com.cr.services.repository.IRepositoryServices;

public class RolRepository implements IRepositoryServices<Rol> {

    IConnection _connection;
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String INSERT_QUERY = "INSERT INTO rol VALUES(null,?,?)";
    private final String UPDATE_QUERY = """
            UPDATE rol SET name=?, description=? WHERE id_rol=?
            """;
    private final String GET_ALL_QUERY = "SELECT * FROM rol";

    public RolRepository() throws IOException {
        _connection = new MysqlConnection(null);
    }

    @Override
    public void create(Rol model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(INSERT_QUERY);
            pstm.setString(2, model.getName());
            pstm.setString(3, model.getDescription());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }
    }

    @Override
    public void update(Rol model) {
        conn = _connection.connect();
        try {
            pstm = conn.prepareStatement(UPDATE_QUERY);
            pstm.setInt(1, model.getIdRol());
            pstm.setString(2, model.getName());
            pstm.setString(3, model.getDescription());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Insert: " + e.getMessage());
        } finally {
            _connection.close(pstm);
            _connection.close(conn);
        }

    }

    public List<Rol> getAll() {
        conn = _connection.connect();
        List<Rol> roles = new ArrayList<>();
        try {

            rs = conn.createStatement().executeQuery(GET_ALL_QUERY);
            if (rs.next()) {
                var rol = new Rol();
                rol.setIdRol(rs.getInt(1));
                rol.setName(rs.getString(2));
                rol.setDescription(rs.getString(3));
                roles.add(rol);
            }

        } catch (SQLException e) {

            System.err.println("Error Find");
        } finally {
            _connection.close(rs);
            _connection.close(pstm);
            _connection.close(conn);

        }

        return roles;
    }

    @Override
    public Rol find(Predicate<Rol> filter) {
        for (Rol rol : getAll()) {
            if (filter.test(rol)) {
                return rol;
            }
        }
        return null;
    }


}
