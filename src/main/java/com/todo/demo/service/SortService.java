package com.todo.demo.service;

import com.todo.demo.entity.Task;
import com.todo.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> sortByPriority(int option) {
        List<Task> todoList = taskRepository.findAll();
        if (!todoList.isEmpty()) {
            if (option == 1)
                todoList.sort((task1, task2) -> task1.getPriority().compareTo(task2.getPriority()));
            else
                todoList.sort((task1, task2) -> task2.getPriority().compareTo(task1.getPriority()));
            return todoList;
        }
        return null;
    }
}
