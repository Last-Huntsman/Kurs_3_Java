package ru.zyuzyukov.kurs_3_java.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Worker;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SkillDtoForWorker extends SkillDto {
    public SkillDtoForWorker(UUID id, String name, List<UUID> workers) {
        super(id, name);
        this.workers = workers;
    }

    private List<UUID> workers = new ArrayList<>();
}
