package ru.zyuzyukov.kurs_3_java.db.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Entitytable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    // @Column(name = "id")
    private UUID id;

    // @NotBlank()
    // @Column(name = "name", length = 50)
    private String name;

}
