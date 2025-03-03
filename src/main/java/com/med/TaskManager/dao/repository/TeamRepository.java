package com.med.TaskManager.dao.repository;

import com.med.TaskManager.dao.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
