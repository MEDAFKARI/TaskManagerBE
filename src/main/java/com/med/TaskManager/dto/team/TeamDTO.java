package com.med.TaskManager.dto.team;

import com.med.TaskManager.dao.entity.User;
import com.med.TaskManager.dto.task.TaskDTO;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO{
    private Long id;
    private String name;
    private String goal;
    private Long team_manager;
    private List<Long> membersId;
    private List<TaskDTO> tasks;
}
