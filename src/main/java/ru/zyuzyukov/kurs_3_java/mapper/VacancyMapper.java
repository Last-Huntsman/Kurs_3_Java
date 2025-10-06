package ru.zyuzyukov.kurs_3_java.mapper;



import ru.zyuzyukov.kurs_3_java.db.entity.Vacancy;

import ru.zyuzyukov.kurs_3_java.dto.VacancyDto;

import java.util.UUID;

public class VacancyMapper implements Mapper<VacancyDto, Vacancy> {




    @Override
    public VacancyDto toDto(Vacancy entity) {

        return new VacancyDto(
                entity.getId(),
                entity.getEmployerId(),
                entity.getSalary(),
                entity.getDescription(),
                entity.getPost()
        );
    }

    @Override
    public Vacancy toCreateEntity(VacancyDto dto) {


        return new Vacancy(
                dto.getId(),
                dto.getEmployerId(),
                dto.getSalary(),
                dto.getDescription(),
                dto.getPost()
        );
    }
    public VacancyDto toCreatDto(UUID id, UUID employerId,Integer salary, String description,String post) {
        return new VacancyDto(
               id,employerId,salary,description,post
        );
    }

}
