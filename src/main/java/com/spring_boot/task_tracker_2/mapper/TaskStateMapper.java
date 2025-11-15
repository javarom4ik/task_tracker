package com.spring_boot.task_tracker_2.mapper;

import com.spring_boot.task_tracker_2.dto.ProjectDto;
import com.spring_boot.task_tracker_2.dto.TaskStateDto;
import com.spring_boot.task_tracker_2.entity.Project;
import com.spring_boot.task_tracker_2.entity.TaskState;
import org.springframework.stereotype.Component;

@Component
public class TaskStateMapper {

    public TaskStateDto toDto(TaskState taskState) {
        return new TaskStateDto(
                taskState.getId(),
                taskState.getName(),
                taskState.getOrdinal(),
                taskState.getCreatedAt());
    }
}
