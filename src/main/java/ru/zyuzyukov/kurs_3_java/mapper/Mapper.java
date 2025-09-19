package ru.zyuzyukov.kurs_3_java.mapper;


import ru.zyuzyukov.kurs_3_java.db.entity.Entitytable;
import ru.zyuzyukov.kurs_3_java.dto.CRUDable;

public interface Mapper<T extends CRUDable, D extends Entitytable> {
    T toDto(D entity);

    D toCreateEntity(T dto);

}
