package com.med.TaskManager.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class ExceptionDetail {
    private String message;
    private LocalDateTime timestamp;
    private String details;
    private String requestUrl;
}
