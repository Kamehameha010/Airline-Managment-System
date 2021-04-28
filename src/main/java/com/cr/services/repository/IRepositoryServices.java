package com.cr.services.repository;

import java.util.List;

import com.cr.model.Identity;

public interface IRepositoryServices<T extends Identity> extends ICreate<T>, IUpdate<T>, IDelete, IFind<T> {
    List<T> getAll();
}
