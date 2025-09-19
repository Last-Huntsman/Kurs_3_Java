package ru.zyuzyukov.kurs_3_java.db.service;


import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Entitytable;
import ru.zyuzyukov.kurs_3_java.db.repositories.JpaRepository;
import ru.zyuzyukov.kurs_3_java.dto.CRUDable;
import ru.zyuzyukov.kurs_3_java.mapper.Mapper;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
public class BaseService<D extends CRUDable, T extends Entitytable> {
    private final JpaRepository<T, UUID> repository;
    private final Mapper<D, T> mapper;
    public List<D> findAll() {
        List<T> list = repository.findAll();
        return list.stream().map(mapper::toDto).toList();
    }
    public D findById(UUID id) {
        T entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("entity not found")
        );
        return mapper.toDto(entity);
    }

    public D save(D d) {
        T entity = mapper.toCreateEntity(d);
        T save = repository.save(entity);
        return mapper.toDto(save);
    }

    public D update(D d) {
        T entity = mapper.toCreateEntity(d);
        T save = repository.update(entity);
        return mapper.toDto(save);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) return;
        repository.deleteById(id);

    }


}
