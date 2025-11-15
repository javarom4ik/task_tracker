package com.spring_boot.task_tracker_2.repo;


import com.spring_boot.task_tracker_2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
