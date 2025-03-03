package com.med.TaskManager.service;

import com.med.TaskManager.dao.entity.Team;
import com.med.TaskManager.dto.task.TaskDTO;
import com.med.TaskManager.dto.team.TeamDTO;

import java.util.List;

public interface TeamService {
    List<TeamDTO> getTeams();
    List<TaskDTO> affectTaskToTeam(Long taskId, Long teamId);
    List<Team> addUserToTeam(String team, Long user);
    TeamDTO affectTeamManager(Long team , Long user);
}
