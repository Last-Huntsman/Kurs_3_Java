package ru.zyuzyukov.kurs_3_java.db.repositories;



import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Worker;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class WorkerRepository implements JpaRepository<Worker, UUID> {
    private final ConnectionManager connectionManager;

    @Override
    public List<Worker> findAll() {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * from worker");
            ResultSet set = statement.executeQuery();
            List<Worker> workers = new ArrayList<>();
            while (set.next()) {
                workers.add(new Worker((UUID) set.getObject("id"), set.getString("name")));
            }
            return workers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Worker> findById(UUID id) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from worker where id = ?");
            statement.setObject(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return Optional.of(new Worker(id, set.getString("name")));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Worker save(Worker worker) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("INSERT into worker " +
                    "(id,name) values ( ?,? )");
            statement.setObject(1, worker.getId());
            statement.setString(2, worker.getName());
            statement.executeUpdate();
            return findById(worker.getId()).orElseThrow(()-> new SQLException("worker not save"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Worker update(Worker worker) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE worker " +
                    "SET name = ? WHERE id = ?");
            statement.setString(1, worker.getName());
            statement.setObject(2, worker.getId());
            statement.executeUpdate();
            return findById(worker.getId()).orElseThrow(()-> new SQLException("worker not update"));
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
            PreparedStatement statement = connection.prepareStatement("DELETE from worker where id = ?");
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
