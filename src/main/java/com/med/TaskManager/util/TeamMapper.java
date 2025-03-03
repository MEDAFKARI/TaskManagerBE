package com.med.TaskManager.util;


import com.med.TaskManager.dao.entity.Team;
import com.med.TaskManager.dto.team.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamMapper {
    private final ModelMapper mapper;


    public TeamDTO fromTeamToTeamDTO(Team team){
        return mapper.map(team, TeamDTO.class);
    }


    public Team fromTeamDTOToTeam(TeamDTO team){
        return mapper.map(team, Team.class);
    }





}
