package com.med.TaskManager.dao.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    private String id;
    private String name;
    private String goal;
    private Long team_manager;
    @OneToMany(mappedBy = "team")
    private List<User> members;
    @OneToMany(mappedBy = "team")
    private List<Task> task;
}
