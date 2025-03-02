package com.med.TaskManager.service;

import com.med.TaskManager.dao.entity.Task;
import com.med.TaskManager.dto.CreateTaskDTO;
import com.med.TaskManager.dto.TaskDTO;
import com.med.TaskManager.exception.TaskAlreadyExistsException;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(CreateTaskDTO task) throws TaskAlreadyExistsException;

    List<TaskDTO> getTasks();
}