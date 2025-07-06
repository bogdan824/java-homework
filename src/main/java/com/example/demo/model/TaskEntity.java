package com.example.demo.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("tasks")
public class TaskEntity {

    @PrimaryKey
    private UUID id;
    private String title;
    private boolean done;

    public TaskEntity() {
        this.id = UUID.randomUUID();
    }

    public TaskEntity(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.done = false;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
