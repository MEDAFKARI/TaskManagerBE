package com.med.TaskManager.dao.repository;

import com.med.TaskManager.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
