package ru.zyuzyukov.kurs_3_java.mapper;


import ru.zyuzyukov.kurs_3_java.db.entity.Employment;
import ru.zyuzyukov.kurs_3_java.dto.EmploymentDto;

import java.time.LocalDate;


public class EmploymentMapper implements Mapper<EmploymentDto, Employment> {


    @Override
    public EmploymentDto toDto(Employment entity) {
        return new EmploymentDto(
                entity.getId(),
                entity.getWorkerId(),
                entity.getVacancyId(),
                entity.getDate_open(),
                entity.getDate_closed()
        );
    }

    @Override
    public Employment toCreateEntity(EmploymentDto dto) {

        return new Employment(
                dto.getId(),
                dto.getWorker_id(),
                dto.getVacancy_id(),
                dto.getDate_close(),
                LocalDate.now()

        );
    }
}
