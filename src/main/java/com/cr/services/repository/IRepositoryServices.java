package com.cr.services.repository;

import java.util.List;

public interface IRepositoryServices<T> extends ICreate<T>, IUpdate<T>, IFind<T> {
    List<T> getAll();
}
