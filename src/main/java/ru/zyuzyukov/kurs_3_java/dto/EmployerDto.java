package ru.zyuzyukov.kurs_3_java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployerDto implements CRUDable {

    private UUID id;

    private String name;

//    private List<UUID> vacancyList = new ArrayList<>();



}
