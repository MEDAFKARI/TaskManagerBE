package com.med.TaskManager.dto.task;

import com.med.TaskManager.enums.Flag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDTO {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Flag flag;
    private Long userId;
}
