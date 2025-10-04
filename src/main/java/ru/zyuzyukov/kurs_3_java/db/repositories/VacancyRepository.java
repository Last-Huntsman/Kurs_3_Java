package ru.zyuzyukov.kurs_3_java.db.repositories;



import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.db.entity.Vacancy;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class VacancyRepository implements JpaRepository<Vacancy, UUID> {
    private final ConnectionManager connectionManager;

    @Override
    public List<Vacancy> findAll() {
        try(var connection = connectionManager.open()){
            PreparedStatement statement = connection.prepareStatement("SELECT * from vacancy");
            ResultSet set = statement.executeQuery();
            List<Vacancy> vacancyList = new ArrayList<>();
            while (set.next()){
                vacancyList.add(
                        new Vacancy(
                                (UUID) set.getObject("id"),
                                (UUID) set.getObject("employer_id"),
                                set.getInt("salary"),
                                set.getString("description"),
                                set.getString("post"),
                                set.getBoolean("active")
                        )
                );
            }
            return vacancyList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Vacancy> findById(UUID id) {
        try(var connection = connectionManager.open()){
            PreparedStatement statement = connection.prepareStatement("SELECT * from vacancy v WHERE v.id = ?");
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            Optional<Vacancy> optional = Optional.empty();
            while (set.next()){
                        optional = Optional.of(
                        new Vacancy(
                                (UUID) set.getObject("id"),
                                (UUID) set.getObject("employer_id"),
                                set.getInt("salary"),
                                set.getString("description"),
                                set.getString("post"),
                                set.getBoolean("active")
                        )
                );
            }
            return optional;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        try(var connection = connectionManager.open()){
            PreparedStatement statement = connection.prepareStatement("INSERT into vacancy " +
                    "(id,employer_id,salary,description,post,active) values" +
                    " ( ?,?,?,?,?,? )");
            statement.setObject(1,vacancy.getId());
            statement.setObject(2,vacancy.getEmployerId());
            statement.setInt(3,vacancy.getSalary());
            statement.setString(4,vacancy.getDescription());
            statement.setString(5,vacancy.getPost());
            statement.setBoolean(6,vacancy.getActive());

            statement.executeUpdate();
            return findById(vacancy.getId()).orElseThrow(()-> new SQLException("vacancy not save"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
        try(var connection = connectionManager.open()){
            PreparedStatement statement = connection.prepareStatement("UPDATE vacancy SET employer_id =?,salary =?,description=?,post=?,active=? where id= ? ");
            statement.setObject(6,vacancy.getId());
            statement.setObject(1,vacancy.getEmployerId());
            statement.setInt(2,vacancy.getSalary());
            statement.setString(3,vacancy.getDescription());
            statement.setString(4,vacancy.getPost());
            statement.setBoolean(5,vacancy.getActive());

            statement.executeUpdate();
            return findById(vacancy.getId()).orElseThrow(()-> new SQLException("vacancy not update"));

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
        try(var connection = connectionManager.open()){
            PreparedStatement statement =
                    connection.prepareStatement("DELETE from vacancy where id =?");
                    statement.setObject(1,id);
                    statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
