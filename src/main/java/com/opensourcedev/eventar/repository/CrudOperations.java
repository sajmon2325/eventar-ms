package com.opensourcedev.eventar.repository;


import java.util.Optional;
import java.util.Set;

public interface CrudOperations<T, ID> {

    <S extends T> S save(S var1);
    Optional<T> findById(ID var1);
    boolean existsById(ID var1);
    Set<T> findAll();
    long count();
    void deleteById(ID var1);
    void deleteAll();

}
