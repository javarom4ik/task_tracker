package com.spring_boot.task_tracker_2.repo;

import com.spring_boot.task_tracker_2.entity.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStateRepository extends JpaRepository<TaskState,Long> {
}
