package com.med.TaskManager.controller;

import com.med.TaskManager.dto.TaskDTO;
import com.med.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
