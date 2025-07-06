package com.example.demo.repository;

import com.example.demo.model.TaskEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends CassandraRepository<TaskEntity, UUID> {
}
