package ru.zyuzyukov.kurs_3_java.db.repositories;


import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Skill;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class SkillRepository implements JpaRepository<Skill, UUID> {
    private final ConnectionManager connectionManager;

    @Override
    public List<Skill> findAll() {
        return List.of();
    }

    @Override
    public Optional<Skill> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Skill save(Skill skill) {
        return null;
    }

    @Override
    public Skill update(Skill skill) {
        return null;
    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
