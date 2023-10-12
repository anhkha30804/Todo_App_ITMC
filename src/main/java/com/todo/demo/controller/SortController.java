package com.todo.demo.controller;

import com.todo.demo.entity.Task;
import com.todo.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SortController {

    @Autowired
    private SortService sortService;

    @GetMapping("/sort-task")
    public String sortByPriority(Model model) {
        List<Task> sortResult = sortService.sortByPriority();
        if (!sortResult.isEmpty()) {
            model.addAttribute("todoList", sortResult);
            return "index";
        }
        return "redirect:/";
    }


}
