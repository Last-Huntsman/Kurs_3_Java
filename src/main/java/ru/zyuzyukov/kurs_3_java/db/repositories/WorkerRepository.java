package ru.zyuzyukov.kurs_3_java.db.repositories;



import ru.zyuzyukov.kurs_3_java.db.entity.Worker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkerRepository implements JpaRepository<Worker, UUID> {

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
