package ru.zyuzyukov.kurs_3_java.mapper;


import ru.zyuzyukov.kurs_3_java.db.entity.Skill;
import ru.zyuzyukov.kurs_3_java.dto.SkillDto;
import ru.zyuzyukov.kurs_3_java.dto.SkillDtoForVacancy;
import ru.zyuzyukov.kurs_3_java.dto.SkillDtoForWorker;

import java.util.ArrayList;


public class SkillMapper {

    public SkillDtoForVacancy toVacancyDto(Skill entity) {
        return new SkillDtoForVacancy(
                entity.getId(),
                entity.getName(),
                entity.getVacancies()
        );
    }

    public SkillDtoForWorker toWorkerDto(Skill entity) {
        return new SkillDtoForWorker(
                entity.getId(),
                entity.getName(),
                entity.getWorkers()
        );
    }

    public Skill toEntity(SkillDto dto) {
        if (dto instanceof SkillDtoForVacancy vacancyDto) {
            return new Skill(
                    vacancyDto.getId(),
                    vacancyDto.getName(),
                    vacancyDto.getVacancies(),
                    new ArrayList<>()
            );
        } else if (dto instanceof SkillDtoForWorker workerDto) {
            return new Skill(
                    workerDto.getId(),
                    workerDto.getName(),
                    new ArrayList<>(),
                    workerDto.getWorkers()
            );
        }
        throw new IllegalArgumentException("Unsupported DTO type: " + dto.getClass());
    }

    public Skill createEntity(SkillDto dto) {
        return new Skill(
                dto.getId(),
                dto.getName(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    public SkillDto createDto(Skill entity) {
        return new SkillDto(entity.getId(), entity.getName());
    }
}
