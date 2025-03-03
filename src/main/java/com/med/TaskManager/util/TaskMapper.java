package com.med.TaskManager.util;

import com.med.TaskManager.dao.entity.Task;
import com.med.TaskManager.dto.task.CreateTaskDTO;
import com.med.TaskManager.dto.task.TaskDTO;
import com.med.TaskManager.dto.task.UpdateTaskDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMapper {
    private final ModelMapper mapper;

    public Task mapToTask(CreateTaskDTO task) {
        return mapper.map(task, Task.class);
    }

    public Task mapToTask(UpdateTaskDTO task) {
        return mapper.map(task, Task.class);
    }

    public TaskDTO mapToTaskDTO(Task task) {
        return mapper.map(task, TaskDTO.class);
    }
}
