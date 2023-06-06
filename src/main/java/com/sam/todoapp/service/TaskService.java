package com.sam.todoapp.service;

import com.sam.todoapp.mapper.TaskInDTOToTask;
import com.sam.todoapp.persistence.entity.Task;
import com.sam.todoapp.persistence.entity.TaskStatus;
import com.sam.todoapp.persistence.repository.TaskRepository;
import com.sam.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }
}
