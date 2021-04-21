package com.cr.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ISQLConnection {

    Connection connect();

    void close(Connection conn);

    void close(PreparedStatement pstm);

    void close(ResultSet rs);
}
