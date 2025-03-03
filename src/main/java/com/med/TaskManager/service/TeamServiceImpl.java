package com.med.TaskManager.service;

import com.med.TaskManager.dao.entity.Task;
import com.med.TaskManager.dao.entity.Team;
import com.med.TaskManager.dao.repository.TaskRepository;
import com.med.TaskManager.dao.repository.TeamRepository;
import com.med.TaskManager.dto.task.TaskDTO;
import com.med.TaskManager.dto.team.TeamDTO;
import com.med.TaskManager.util.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final TaskRepository taskRepository;


    @Override
    public List<TeamDTO> getTeams() {
        return teamRepository.findAll().stream().map(team -> teamMapper.fromTeamToTeamDTO(team)).collect(Collectors.toList());

    }


    @Override
    public List<TaskDTO> affectTaskToTeam(Long taskId, Long teamId) {
        Task task = taskRepository.findById(taskId).get();
        Team team = teamRepository.findById(teamId).get();
        task.setTeam(team);
        team.getTask().add(task);

        return List.of();
    }

    @Override
    public List<Team> addUserToTeam(String team, Long user) {
        return List.of();
    }

    @Override
    public TeamDTO affectTeamManager(Long team, Long user) {
        return null;
    }
}
