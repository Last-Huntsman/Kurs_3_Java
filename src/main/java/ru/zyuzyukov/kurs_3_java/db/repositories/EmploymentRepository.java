package ru.zyuzyukov.kurs_3_java.db.repositories;


import ru.zyuzyukov.kurs_3_java.db.entity.Employment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmploymentRepository implements JpaRepository<Employment, UUID> {
    @Override
    public List<Employment> findAll() {
        return List.of();
    }

    @Override
    public Optional<Employment> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Employment save(Employment employment) {
        return null;
    }

    @Override
    public Employment update(Employment employment) {
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


