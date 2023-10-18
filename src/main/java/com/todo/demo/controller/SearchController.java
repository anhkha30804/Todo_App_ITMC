package com.todo.demo.controller;

import com.todo.demo.entity.Task;
import com.todo.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public String searchByTitle(@RequestParam("searchTitle") String searchTitle, Model model) {
        List<Task> searchResult = searchService.searchByTitle(searchTitle);
        if (!searchResult.isEmpty()) {
            model.addAttribute("todoList", searchResult);
            return "index";
        }
        return "redirect:/";
    }

}
