package com.med.TaskManager.dao.repository;

import com.med.TaskManager.dao.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {


    Optional<Task> findByName(String name);
}
