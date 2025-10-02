package ru.zyuzyukov.kurs_3_java.db.repositories;


import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Employer;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RequiredArgsConstructor
public class EmployerRepository implements JpaRepository<Employer, UUID> {
    private final ConnectionManager connectionManager;

    @Override
    public List<Employer> findAll() {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * from employer");
            ResultSet set = statement.executeQuery();
            List<Employer> employers = new ArrayList<>();
            while (set.next()) {
                employers.add(new Employer((UUID) set.getObject("id"), set.getString("name"), set.getBoolean("active")));
            }
            return employers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employer> findById(UUID id) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from employer where id = ?");
            statement.setObject(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return Optional.of(new Employer(id, set.getString("name"), set.getBoolean("active")));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employer save(Employer employer) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("INSERT into employer " +
                    "(id,name,active) values ( ?,?,? )");
            statement.setObject(1, employer.getId());
            statement.setString(2, employer.getName());
            statement.setBoolean(3, employer.getActive());
            statement.executeUpdate();
            return findById(employer.getId()).orElseThrow(()-> new SQLException("Employer not save"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employer update(Employer employer) {
        try (var connection = connectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE employer " +
                    "SET name = ?, active = ? WHERE id = ?");
            statement.setString(1, employer.getName());
            statement.setBoolean(2, employer.getActive());
            statement.setObject(3, employer.getId());
            statement.executeUpdate();
            return findById(employer.getId()).orElseThrow(()-> new SQLException("Employer not update"));
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
            PreparedStatement statement = connection.prepareStatement("DELETE from employer where id = ?");
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
