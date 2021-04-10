package com.opensourcedev.eventar.repository;


import java.util.Optional;
import java.util.Set;

public interface CrudOperations<T, ID> {

    <S extends T> S saveEntity(S var1);
    Optional<T> findEntityById(ID var1);
    boolean existsEntityById(ID var1);
    Set<T> findAllEntities();
    long countEntities();
    void deleteEntityById(ID var1);
    void deleteAllEntities();

}
