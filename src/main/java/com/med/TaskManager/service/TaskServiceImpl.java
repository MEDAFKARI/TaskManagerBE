package com.med.TaskManager.service;

import com.med.TaskManager.dao.entity.Task;
import com.med.TaskManager.dao.repository.TaskRepository;
import com.med.TaskManager.dto.task.CreateTaskDTO;
import com.med.TaskManager.dto.task.TaskDTO;
import com.med.TaskManager.exception.TaskAlreadyExistsException;
import com.med.TaskManager.exception.TaskNotFoundException;
import com.med.TaskManager.util.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;


    @Override
    public TaskDTO createTask(CreateTaskDTO task) throws TaskAlreadyExistsException {
        Task taskEntity = taskMapper.mapToTask(task);
        if (taskRepository.findByName(task.getName()).isPresent()) {
            throw new TaskAlreadyExistsException("Task with the same name already exists");
        }
        System.out.println(taskEntity);
        taskEntity.setDone(false);

        taskRepository.save(taskEntity);
        return taskMapper.mapToTaskDTO(taskEntity);
    }

    @Override
    public List<TaskDTO> getTasks() {
        List<Task> tasks =taskRepository.findAll();
        List<TaskDTO> tasksDTO = tasks.stream().map(task -> taskMapper.mapToTaskDTO(task)).collect(Collectors.toList());
        return tasksDTO;
    }

    @Override
    public TaskDTO endTask(Long Id) throws TaskNotFoundException{
        Optional<Task> task= taskRepository.findById(Id);
        if (!task.isPresent()) {
            throw new TaskNotFoundException("Task not found : " + Id);
        }
        task.get().setDone(true);
        Task endedTask=taskRepository.save(task.get());
        return taskMapper.mapToTaskDTO(endedTask);
    }
}
