package ru.zyuzyukov.kurs_3_java.db.repositories;


import ru.zyuzyukov.kurs_3_java.db.entity.Employer;

import java.util.*;

public class EmployerRepository implements JpaRepository<Employer, UUID> {
    List<Employer> employers = new ArrayList<>(List.of(
            new Employer(UUID.randomUUID(),"1",true,new ArrayList<>()),
            new Employer(UUID.randomUUID(),"2",true,new ArrayList<>())
    ));


    @Override
    public List<Employer> findAll() {
        return employers;
    }

    @Override
    public Optional<Employer> findById(UUID id) {
       return employers.stream().filter(employer -> employer.getId().equals(id)).findFirst();
    }

    @Override
    public Employer save(Employer employer) {
        employers.add(employer);
        return employer;
    }

    @Override
    public Employer update(Employer employer) {
       Employer employer1 =  findById(employer.getId()).orElse(null);
       Objects.requireNonNull(employer1).setName(employer.getName());
       return employer1;
    }

    @Override
    public boolean existsById(UUID id) {
        return findById(id).isPresent();
    }

    @Override
    public void deleteById(UUID id) {

        employers.remove(findById(id).orElse(null));
    }
}
