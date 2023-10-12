package com.todo.demo.service;

import com.todo.demo.entity.Task;
import com.todo.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class SortService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> sortByPriority() {
        List<Task> todoList = taskRepository.findAll();
        if (!todoList.isEmpty()) {
            todoList.sort(Comparator.comparing(Task::getPriority));
            return todoList;
        }
        return null;
    }
}
