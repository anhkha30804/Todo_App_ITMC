package com.todo.demo.controller;

import com.todo.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TaskService service;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("todoList", service.getAll());
        return "index";
    }
}
