package com.cr.services.repository;

import com.cr.model.Identity;

public interface IUpdate<T extends Identity> {

    void update(T model);
}
