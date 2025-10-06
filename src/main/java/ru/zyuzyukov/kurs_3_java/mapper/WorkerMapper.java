package ru.zyuzyukov.kurs_3_java.mapper;


import ru.zyuzyukov.kurs_3_java.db.entity.Worker;
import ru.zyuzyukov.kurs_3_java.dto.WorkerDto;

import java.util.UUID;


public class WorkerMapper implements Mapper<WorkerDto, Worker> {

    @Override
    public WorkerDto toDto(Worker entity) {
        return new WorkerDto(
                entity.getId(),
                entity.getName()

        );
    }

    @Override
    public Worker toCreateEntity(WorkerDto dto) {
        return new Worker(
                dto.getId(),
                dto.getName()
        );
    }
    public WorkerDto createDto(UUID id,String name){
        return new WorkerDto(id,name);
    }
}
