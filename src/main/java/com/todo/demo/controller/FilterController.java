package com.todo.demo.controller;

import com.todo.demo.common.Priority;
import com.todo.demo.common.Status;
import com.todo.demo.entity.Task;
import com.todo.demo.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/filter")
    public String filterTask(@RequestParam(name = "status", required = false) Status status,
                             @RequestParam(name = "priority", required = false) Priority priority,
                             @RequestParam(name = "finishDay", required = false) LocalDate finishDay,
                             Model model) {

        Status statusStr = getStatusEnum(String.valueOf(status));
        Priority priorityStr = getPriorityEnum(String.valueOf(priority));

        if (statusStr == null && priorityStr == null && finishDay == null)
            return "redirect:/";

        List<Task> filterResult= filterService.filterTask(status, priority, finishDay);
        model.addAttribute("todoList", filterResult);

        return "index";
    }

    private Status getStatusEnum(String statusStr) {
        try {
            return Status.valueOf(statusStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Priority getPriorityEnum(String priorityStr) {
        try {
            return Priority.valueOf(priorityStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}