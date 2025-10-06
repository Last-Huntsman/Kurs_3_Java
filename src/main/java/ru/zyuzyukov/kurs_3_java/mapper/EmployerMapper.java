package ru.zyuzyukov.kurs_3_java.mapper;

import ru.zyuzyukov.kurs_3_java.db.entity.Employer;
import ru.zyuzyukov.kurs_3_java.dto.EmployerDto;
import ru.zyuzyukov.kurs_3_java.dto.WorkerDto;

import java.util.UUID;


public class EmployerMapper implements Mapper<EmployerDto, Employer> {

    @Override
    public EmployerDto toDto(Employer entity) {
        return new EmployerDto(
                entity.getId(),
                entity.getName());
    }

    @Override
    public Employer toCreateEntity(EmployerDto dto) {

        return new Employer(
                dto.getId(),
                dto.getName()
        );
    }

    public EmployerDto createDto(UUID id, String name) {
        return new EmployerDto(id, name);
    }
}
