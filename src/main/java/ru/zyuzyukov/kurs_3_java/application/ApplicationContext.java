package ru.zyuzyukov.kurs_3_java.application;

import lombok.Getter;
import ru.zyuzyukov.kurs_3_java.db.entity.*;
import ru.zyuzyukov.kurs_3_java.db.repositories.*;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.*;
import ru.zyuzyukov.kurs_3_java.jdbc.ConnectionManager;
import ru.zyuzyukov.kurs_3_java.mapper.*;

public class ApplicationContext {

    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
    private final EmployerRepository employerRepository = new EmployerRepository(connectionManager);
    @Getter
    private final EmployerMapper employerMapper = new EmployerMapper();
    private final EmploymentRepository employmentRepository = new EmploymentRepository(connectionManager);
    @Getter
    private final EmploymentMapper employmentMapper = new EmploymentMapper();
    private final VacancyRepository vacancyRepository = new VacancyRepository(connectionManager);
    @Getter
    private final VacancyMapper vacancyMapper = new VacancyMapper();
    private final WorkerRepository workerRepository = new WorkerRepository(connectionManager);
    @Getter
    private final WorkerMapper workerMapper = new WorkerMapper();

    public BaseService<EmployerDto, Employer> getEmployerService() {
        return new BaseService<>(employerRepository, employerMapper);
    }

    public BaseService<EmploymentDto, Employment> getEmploymentService() {
        return new BaseService<>(employmentRepository, employmentMapper);
    }

    public BaseService<VacancyDto, Vacancy> getVacancyService() {
        return new BaseService<>(vacancyRepository, vacancyMapper);
    }

    public BaseService<WorkerDto, Worker> getWorkerService() {
        return new BaseService<>(workerRepository, workerMapper);
    }
}
