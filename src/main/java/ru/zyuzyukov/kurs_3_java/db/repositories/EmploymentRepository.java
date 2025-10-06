package ru.zyuzyukov.kurs_3_java.db.repositories;


import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Employment;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class EmploymentRepository implements JpaRepository<Employment, UUID> {
    private final ConnectionManager connectionManager;

    @Override
    public List<Employment> findAll() {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * from employment");
            ResultSet set = statement.executeQuery();
            List<Employment> list = new ArrayList<>();
            while (set.next()) {
                list.add(new Employment((UUID) set.getObject("id"),
                        (UUID) set.getObject("worker_id"),
                        (UUID) set.getObject("vacancy_id"),
                        set.getDate("date_open") != null ? set.getDate("date_open").toLocalDate() : null
                        , set.getDate("date_closed") != null ? set.getDate("date_closed").toLocalDate() : null
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employment> findById(UUID id) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employment WHERE id=?");
            statement.setObject(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return Optional.of(new Employment((UUID) set.getObject("id"),
                        (UUID) set.getObject("worker_id"),
                        (UUID) set.getObject("vacancy_id"),
                        set.getDate("date_open") != null ? set.getDate("date_open").toLocalDate() : null
                        , set.getDate("date_closed") != null ? set.getDate("date_closed").toLocalDate() : null
                ));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employment save(Employment employment) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("INSERT into employment " +
                    "(id,worker_id,vacancy_id,date_open,date_closed) values ( ?,?,?,?,? )");
            statement.setObject(1, employment.getId());
            statement.setObject(2, employment.getWorkerId());
            statement.setObject(3, employment.getVacancyId());
            statement.setDate(4, employment.getDate_open() != null ? Date.valueOf(employment.getDate_open()) : null);
            statement.setDate(5, employment.getDate_closed() != null ? Date.valueOf(employment.getDate_closed()) : null);
            statement.executeUpdate();
            return findById(employment.getId()).orElseThrow(() -> new SQLException("Employment not save"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employment update(Employment employment) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE employment SET date_open =? ,date_closed=? WHERE id =?");
            statement.setObject(3, employment.getId());

            statement.setDate(1, employment.getDate_open() != null ? Date.valueOf(employment.getDate_open()) : null);
            statement.setDate(2, employment.getDate_closed() != null ? Date.valueOf(employment.getDate_closed()) : null);

            statement.executeUpdate();
            return findById(employment.getId()).orElseThrow(() -> new SQLException("Employment not update"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return findById(id).isPresent();
    }

    @Override
    public void deleteById(UUID id) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM employment where id =?");
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


