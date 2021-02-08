package com.opensourcedev.eventar.repository;


import java.util.Optional;

public interface CrudOperations<T, ID> {

    <S extends T> S save(S var1);
    Optional<T> findById(ID var1);
    boolean existsById(ID var1);
    Iterable<T> findAll();
    long count();
    void deleteById(ID var1);
    void deleteAll();

}
