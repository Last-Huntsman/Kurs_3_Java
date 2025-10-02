package ru.zyuzyukov.kurs_3_java.mapper;

import ru.zyuzyukov.kurs_3_java.db.entity.Employer;
import ru.zyuzyukov.kurs_3_java.dto.EmployerDto;


public class EmployerMapper implements Mapper<EmployerDto, Employer> {

    @Override
    public EmployerDto toDto(Employer entity) {
        return new EmployerDto(
                entity.getId(),
                entity.getName(),
                entity.getActive());
    }

    @Override
    public Employer toCreateEntity(EmployerDto dto) {

        return new Employer(
                dto.getId(),
                dto.getName(),
                dto.getActive()

        );
    }
}
