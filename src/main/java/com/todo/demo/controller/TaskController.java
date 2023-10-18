package com.todo.demo.controller;

import com.todo.demo.entity.Task;
import com.todo.demo.repository.TaskRepository;
import com.todo.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping("/add-task")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "new-task";
    }

    @PostMapping("/save-task")
    public String saveTask(Task task) {
        task.setStartDay(LocalDate.now());
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit-task/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Task task = taskService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task id: " + id + " not found"));
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/update-task/{id}")
    public String updateTask(@PathVariable("id") Integer id, Task task) {
        Task updateTask = taskService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task id: " + id + " not found"));

        updateTask.setStatus(task.getStatus());
        updateTask.setTitle(task.getTitle());
        updateTask.setPriority(task.getPriority());
        updateTask.setNote(task.getNote());

        if (task.getFinishDay() != null)
            updateTask.setFinishDay(task.getFinishDay());

        taskService.save(updateTask);
        return "redirect:/";
    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable("id") Integer id) {
        Task task = taskService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task id: " + id + " not found"));
        taskService.delete(task);
        return "redirect:/";
    }
}
