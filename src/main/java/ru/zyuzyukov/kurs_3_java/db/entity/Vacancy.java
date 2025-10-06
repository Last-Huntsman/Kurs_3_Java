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
public class Vacancy implements Entitytable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // @ManyToOne
    // @JoinColumn(name = "employer_id", nullable = false)
    private UUID employerId;

    // @NotNull
    // @Min(value = 0)
    private Integer salary;

    // @NotBlank
    // @Size(max = 5000)
    private String description;

    // @NotBlank
    // @Size(max = 100)
    private String post;



}
