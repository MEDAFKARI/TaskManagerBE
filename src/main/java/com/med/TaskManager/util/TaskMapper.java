package com.med.TaskManager.util;

import com.med.TaskManager.dao.entity.Task;
import com.med.TaskManager.dto.CreateTaskDTO;
import com.med.TaskManager.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMapper {
    private final ModelMapper mapper = new ModelMapper();

    public Task mapToTask(CreateTaskDTO createTaskDTO) {
        return mapper.map(createTaskDTO, Task.class);
    }

    public TaskDTO mapToTaskDTO(Task task) {
        return mapper.map(task, TaskDTO.class);
    }
}
