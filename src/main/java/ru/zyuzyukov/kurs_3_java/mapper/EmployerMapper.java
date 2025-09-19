package ru.zyuzyukov.kurs_3_java.mapper;

import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Employer;
import ru.zyuzyukov.kurs_3_java.db.entity.Vacancy;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.EmployerDto;
import ru.zyuzyukov.kurs_3_java.dto.VacancyDto;

import java.util.List;


public class EmployerMapper implements Mapper<EmployerDto, Employer> {

    @Override
    public EmployerDto toDto(Employer entity) {
        return new EmployerDto(
                entity.getId(),
                entity.getName(),
                entity.getVacancyList(),
                entity.getActive());
    }

    @Override
    public Employer toCreateEntity(EmployerDto dto) {

        return new Employer(
                dto.getId(),
                dto.getName(),
                dto.getActive(),
                dto.getVacancyList()

        );
    }
}
