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
public class WorkerDto implements CRUDable {
    //при создании не указываем
    private UUID id;

    private String name;


}
