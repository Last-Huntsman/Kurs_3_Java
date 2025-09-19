package ru.zyuzyukov.kurs_3_java.db.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employer implements Entitytable {
    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    // @Column(name = "id")
    private UUID id;

    // @NotBlank()
    // @Column(name = "name", length = 50, unique = true)
    private String name;

    // @NotNull
    private Boolean active = true;

    // @OneToMany(mappedBy = "employer",orphanRemoval = true)
    private List<UUID> vacancyList = new ArrayList<>();
}
