package ru.zyuzyukov.kurs_3_java.db.repositories;

import ru.zyuzyukov.kurs_3_java.db.entity.Entitytable;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T extends Entitytable, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);

    T save(T t);

    T update(T t);

    boolean existsById(ID id);

    void deleteById(ID id);

}
