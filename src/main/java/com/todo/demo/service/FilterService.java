package com.todo.demo.service;

import com.todo.demo.common.Priority;
import com.todo.demo.common.Status;
import com.todo.demo.entity.Task;
import com.todo.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FilterService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> filterTask(Status status, Priority priority, LocalDate finishDay) {
        List<Task> allTasks = taskRepository.findAll();
        Stream<Task> filterResult = allTasks.stream();

        if (status != null) {
            filterResult = filterResult.filter(t -> t.getStatus().equals(status));
        }
        if (priority != null) {
            filterResult = filterResult.filter(t -> t.getPriority().equals(priority));
        }
        if (finishDay != null) {
            filterResult = filterResult.filter(t -> t.getFinishDay().equals(finishDay));
        }

        return filterResult.collect(Collectors.toList());
    }
}

