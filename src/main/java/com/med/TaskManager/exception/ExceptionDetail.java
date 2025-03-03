package com.med.TaskManager.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class ExceptionDetail {
    private String message;
    private LocalDateTime timestamp;
    private String details;
    private HttpStatus ErrorCode;
    private String requestUrl;
}
