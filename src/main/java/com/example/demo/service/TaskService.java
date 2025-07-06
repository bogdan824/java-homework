package com.example.demo.service;

import com.example.demo.model.Task;
import org.springframework.stereotype.Service;
import java.util.function.Predicate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getIncompleteTasks() {
        Predicate<Task> notDone = task -> !task.isDone();
        return tasks.stream()
                .filter(notDone)
                .toList(); // Java 16+; use .collect(Collectors.toList()) if on Java 11
    }

}
