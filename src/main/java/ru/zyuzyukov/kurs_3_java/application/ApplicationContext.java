package ru.zyuzyukov.kurs_3_java.application;

import ru.zyuzyukov.kurs_3_java.db.entity.*;
import ru.zyuzyukov.kurs_3_java.db.repositories.*;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.*;
import ru.zyuzyukov.kurs_3_java.mapper.*;

public class ApplicationContext {
    private  final EmployerRepository employerRepository = new EmployerRepository() ;
    private final EmployerMapper employerMapper = new EmployerMapper() ;
    private final EmploymentRepository employmentRepository = new EmploymentRepository() ;
    private final EmploymentMapper employmentMapper = new EmploymentMapper() ;
    private final SkillRepository skillRepository = new SkillRepository() ;
    private final SkillMapper skillMapper = new SkillMapper() ;
    private final VacancyRepository vacancyRepository = new VacancyRepository() ;
    private final VacancyMapper vacancyMapper = new VacancyMapper() ;
    private final WorkerRepository workerRepository = new WorkerRepository() ;
    private final WorkerMapper workerMapper = new WorkerMapper() ;


    public BaseService<EmployerDto,Employer> getEmployerService() {
        return new BaseService<>(employerRepository, employerMapper);
    }
    public BaseService<SkillDto,Skill> getSkillService() {
        return new BaseService<>(skillRepository,skillMapper);
    }
    public BaseService<EmploymentDto, Employment> getEmploymentService() {
        return new BaseService<>(employmentRepository, employmentMapper);
    }
    public BaseService<VacancyDto,Vacancy> getVacancyService() {
        return new BaseService<>(vacancyRepository, vacancyMapper);
    }
    public BaseService<WorkerDto,Worker> getWorkerService() {
        return new BaseService<>(workerRepository, workerMapper);
    }
}
