package com.med.TaskManager.controller;

import com.med.TaskManager.dto.task.CreateTaskDTO;
import com.med.TaskManager.dto.task.TaskDTO;
import com.med.TaskManager.dto.task.UpdateTaskDTO;
import com.med.TaskManager.exception.TaskAlreadyExistsException;
import com.med.TaskManager.exception.TaskNotFoundException;
import com.med.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    // Restful API endpoints for tasks
    @GetMapping 
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return new ResponseEntity<>(
                taskService.getTasks(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody CreateTaskDTO task) throws TaskAlreadyExistsException {
        return new ResponseEntity<>(
                taskService.createTask(task),
                HttpStatus.OK
        );
    }


    @PostMapping("/{id}")
    public ResponseEntity<TaskDTO> endTask(@PathVariable Long id) throws TaskNotFoundException {
        return new ResponseEntity<>(
                taskService.endTask(id),
                HttpStatus.OK
        );
    }



//    @PutMapping("/{id}")
//    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody  UpdateTaskDTO updateTaskDTO)
//            throws TaskNotFoundException {
//        return new ResponseEntity<>(
//                taskService.updateTask(id, updateTaskDTO),
//                HttpStatus.OK
//        );
//    }



}
