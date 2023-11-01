package com.todo.demo.controller;

import com.todo.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"/", "refresh"})
    public String homePage(Model model) {
        model.addAttribute("todoList", taskService.getAll());
        return "index";
    }

    @GetMapping("/check-task")
    public String showCheckPage(Model model) {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Chưa hoàn thành", taskService.count().get("Chưa hoàn thành"));
        map.put("Đang hoàn thành", taskService.count().get("Đang làm"));
        map.put("Đã hoàn thành", taskService.count().get("Hoàn thành"));

        model.addAttribute("count", taskService.count());
        model.addAttribute("chart", map);
        return "check-task";
    }
}