package com.cr.services.repository;

import java.sql.SQLException;

import com.cr.model.Identity;

public interface ICreate<T extends Identity> {

    void create(T model) throws SQLException;
}
