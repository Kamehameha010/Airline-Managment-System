package com.cr.services.repository;

import java.util.function.Predicate;

public interface IFind<T> {
    T find(Predicate<T> filter);
}
