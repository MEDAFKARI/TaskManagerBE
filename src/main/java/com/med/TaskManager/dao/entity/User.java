package com.med.TaskManager.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    @ManyToOne
    private Team team;
    @OneToOne
    private Task affectedTask;
}
