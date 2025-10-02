package ru.zyuzyukov.kurs_3_java.db.repositories;



import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Worker;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class WorkerRepository implements JpaRepository<Worker, UUID> {
    private final ConnectionManager connectionManager;
    @Override
    public List<Worker> findAll() {
        return List.of();
    }

    @Override
    public Optional<Worker> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Worker save(Worker worker) {
        return null;
    }

    @Override
    public Worker update(Worker worker) {
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
