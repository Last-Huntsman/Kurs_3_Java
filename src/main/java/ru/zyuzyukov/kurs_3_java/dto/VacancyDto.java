package ru.zyuzyukov.kurs_3_java.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDto implements CRUDable {
    //при создании не указываем
    private UUID id;

    private UUID employerId;

    private Integer salary;

    private String description;

    private String post;

    private Boolean active = true;

    private List<UUID> vacancySkills = new ArrayList<>();

}
