package ru.zyuzyukov.kurs_3_java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class SkillDto implements CRUDable {
    private UUID id;
    private String name;

}
