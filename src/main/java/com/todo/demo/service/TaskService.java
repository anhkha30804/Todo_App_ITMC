package com.todo.demo.service;

import com.todo.demo.common.Status;
import com.todo.demo.entity.Task;
import com.todo.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        List<Task> todoList = taskRepository.findAll();
        if (!todoList.isEmpty()) {
            for (Task task : todoList)
                if (!task.getStatus().equals(Status.COMPLETED) && task.getFinishDay().isBefore(LocalDate.now()) && !task.getStatus().equals(Status.CANCELLED))
                    task.setStatus(Status.OVERDUE);
            return todoList;
        }
        return null;
    }

    public Optional<Task> getById(int taskId) {
        return taskRepository.findById(taskId);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public Map<String, Integer> getCountTask() {
        Map<String, Integer> count = new HashMap<>();

        count.put("Chưa hoàn thành", taskRepository.countTaskByStatus(Status.IN_COMPLETE));
        count.put("Hoàn thành", taskRepository.countTaskByStatus(Status.COMPLETED));
        count.put("Đang làm", taskRepository.countTaskByStatus(Status.IN_PROGRESS));
        count.put("Quá hạn", taskRepository.countTaskByStatus(Status.OVERDUE));
        count.put("Bị hủy", taskRepository.countTaskByStatus(Status.CANCELLED));

        return count;
    }
}
