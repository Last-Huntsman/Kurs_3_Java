package ru.zyuzyukov.kurs_3_java.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Vacancy;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SkillDtoForVacancy extends SkillDto {
    public SkillDtoForVacancy(UUID id, String name,List<UUID> vacancies) {
        super(id,name);
        this.vacancies = vacancies;
    }
    private List<UUID> vacancies = new ArrayList<>();


}
