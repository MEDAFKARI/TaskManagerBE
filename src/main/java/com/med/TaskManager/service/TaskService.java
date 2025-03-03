package com.med.TaskManager.service;

import com.med.TaskManager.dto.task.CreateTaskDTO;
import com.med.TaskManager.dto.task.TaskDTO;
import com.med.TaskManager.dto.task.UpdateTaskDTO;
import com.med.TaskManager.enums.Flag;
import com.med.TaskManager.exception.TaskAlreadyExistsException;
import com.med.TaskManager.exception.TaskNotFoundException;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(CreateTaskDTO task) throws TaskAlreadyExistsException;

    List<TaskDTO> getTasks();
    TaskDTO endTask(Long Id) throws TaskNotFoundException;

    TaskDTO updateTask(Long Id, UpdateTaskDTO task) throws TaskNotFoundException;

}