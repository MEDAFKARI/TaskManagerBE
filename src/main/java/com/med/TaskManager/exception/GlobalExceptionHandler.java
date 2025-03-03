package com.med.TaskManager.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(TaskNotFoundException e, HttpServletRequest request) {
        log.error("e: ", e);
        ExceptionDetail exceptionDetail = ExceptionDetail.builder().message(e.getMessage()).timestamp(LocalDateTime.now()).requestUrl(request.getRequestURI()).details(Arrays.toString(e.getStackTrace())).ErrorCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e, HttpServletRequest request) {
        ExceptionDetail exceptionDetail = ExceptionDetail.builder().message(e.getMessage()).timestamp(LocalDateTime.now()).requestUrl(request.getRequestURI()).details(Arrays.toString(e.getStackTrace())).ErrorCode(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
