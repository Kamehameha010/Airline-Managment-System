package com.cr.db.jdbc.mysql;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Predicate;

import com.cr.db.IConnection;
import com.cr.tools.FileProperties;

public class MysqlConnection implements IConnection {

    private Connection conn = null;
    private Properties props;

    private Predicate<String> checkFilename = str -> str == null || str.trim().length() == 0;

    public MysqlConnection(String filename) throws IOException{

        if (checkFilename.test(filename)) {
            filename = "Configuration.props";
        }
        props = FileProperties.readFile(filename);

    }

    @Override
    public java.sql.Connection connect() {
        try {
            conn = DriverManager
                    .getConnection(String.format("jdbc:mysql://%s/%s?user=%s&password=%s", props.getProperty("host"),
                            props.getProperty("dbName"), props.getProperty("user"), props.getProperty("password")));

        } catch (SQLException e) {
            System.out.println("Connection error");
        }

        return conn;
    }

    @Override
    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error close");
            }
        }

    }

    @Override
    public void close(PreparedStatement pstm) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                System.out.println("Error close");
            }
        }

    }

    @Override
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error close");
            }
        }
    }

}
