package com.example.demo.controller;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class HelloController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tasks")
    public String tasks(@RequestParam(required = false) boolean incomplete, Model model) {
        if (incomplete) {
            model.addAttribute("tasks", taskService.getIncompleteTasks());
        } else {
            model.addAttribute("tasks", taskService.getAllTasks());
        }
        return "tasks";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestParam String title) {
        taskService.addTask(title);
        return "redirect:/tasks";
    }

    @PostMapping("/toggle-task")
    public String toggleTask(@RequestParam UUID id) {
        taskService.toggleDone(id);
        return "redirect:/tasks";
    }
}
