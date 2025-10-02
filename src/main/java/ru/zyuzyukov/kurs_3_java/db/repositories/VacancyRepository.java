package ru.zyuzyukov.kurs_3_java.db.repositories;



import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Vacancy;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class VacancyRepository implements JpaRepository<Vacancy, UUID> {
    private final ConnectionManager connectionManager;

    @Override
    public List<Vacancy> findAll() {
        return List.of();
    }

    @Override
    public Optional<Vacancy> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        return null;
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
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
