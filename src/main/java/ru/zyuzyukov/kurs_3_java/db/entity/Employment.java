package ru.zyuzyukov.kurs_3_java.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employment  implements Entitytable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // @ManyToOne
    // @JoinColumn(name = "worker_id", nullable = true)
    private UUID workerId;

    // @ManyToOne
    // @JoinColumn(name = "vacancy_id", nullable = false)
    private UUID vacancyId;

    private LocalDate date_open;
    private LocalDate date_closed;
}
