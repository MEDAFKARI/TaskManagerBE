package com.med.TaskManager.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(TaskAlreadyExistsException e, HttpServletRequest request) {
        ExceptionDetail exceptionDetail = ExceptionDetail.builder().message(e.getMessage()).timestamp(LocalDateTime.now()).requestUrl(request.getRequestURI()).details(e.getMessage()).build();
        return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
