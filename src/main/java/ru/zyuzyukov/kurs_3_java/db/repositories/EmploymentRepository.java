package ru.zyuzyukov.kurs_3_java.db.repositories;


import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Employment;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class EmploymentRepository implements JpaRepository<Employment, UUID> {
    private final ConnectionManager connectionManager;
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


