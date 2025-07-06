package com.example.demo.service;

import com.example.demo.model.TaskEntity;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String title) {
        taskRepository.save(new TaskEntity(title));
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> getIncompleteTasks() {
        return taskRepository.findAll()
                .stream()
                .filter(task -> !task.isDone())
                .toList();
    }

    public void toggleDone(UUID id) {
        taskRepository.findById(id).ifPresent(task -> {
            task.setDone(!task.isDone());
            taskRepository.save(task);
        });
    }
}
