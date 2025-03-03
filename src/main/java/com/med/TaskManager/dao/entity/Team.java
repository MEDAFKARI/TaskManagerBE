package com.med.TaskManager.dao.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String goal;
    @NonNull
    private Long team_manager;
    @OneToMany(mappedBy = "team")
    private List<User> members;
    @OneToMany(mappedBy = "team")
    private List<Task> task;
}
