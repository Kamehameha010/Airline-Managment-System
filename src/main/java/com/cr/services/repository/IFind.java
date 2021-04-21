package com.cr.services.repository;

import com.cr.model.Identity;

public interface IFind<T extends Identity> {
    T find(int id);
}
