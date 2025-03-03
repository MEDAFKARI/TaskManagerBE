package com.med.TaskManager.dao.entity;


import com.med.TaskManager.enums.Flag;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Persistent;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean done;
    private Boolean affected;
    @Enumerated(EnumType.STRING)
    private Flag flag;
    @OneToOne
    private User user;
    @ManyToOne
    private Team team;




}
