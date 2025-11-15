package com.spring_boot.task_tracker_2.repo;

import com.spring_boot.task_tracker_2.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    Optional<Project> findByName(String name);
}
