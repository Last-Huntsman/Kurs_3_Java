package ru.zyuzyukov.kurs_3_java.mapper;


import ru.zyuzyukov.kurs_3_java.db.entity.Employment;
import ru.zyuzyukov.kurs_3_java.dto.EmploymentDto;

import java.time.LocalDate;
import java.util.UUID;


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
                dto.getWorkerId(),
                dto.getVacancyId(),
                dto.getDate_open(),
                dto.getDate_closed()
        );
    }

    public EmploymentDto createDto(UUID id,UUID workerId, UUID vacancyId,LocalDate open, LocalDate closed) {
        return new EmploymentDto(
              id,workerId,vacancyId,open,closed
        );
    }
}
