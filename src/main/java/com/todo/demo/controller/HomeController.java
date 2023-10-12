package com.todo.demo.controller;

import com.todo.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"/", "refresh"})
    public String homePage(Model model) {
        model.addAttribute("todoList", taskService.getAll());
        return "index";
    }

    /*@GetMapping("/check-task")
    public String showCheckPage(Model model) {

        Map<Status, Long> statusCount = todoList.stream()
                .collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));
        model.addAttribute("statusCount", statusCount);
        return "check-task";
    }*/
}
