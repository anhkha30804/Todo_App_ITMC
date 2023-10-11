package com.todo.demo.service;

import com.todo.demo.entity.Task;
import com.todo.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Iterable<Task> getAll() {
        return repository.findAll();
    }

    public Optional<Task> getById(int taskId) {
        return repository.findById(taskId);
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Task task) {
        repository.delete(task);
    }
}
