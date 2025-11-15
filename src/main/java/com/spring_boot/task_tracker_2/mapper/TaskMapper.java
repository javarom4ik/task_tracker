package com.spring_boot.task_tracker_2.mapper;

import com.spring_boot.task_tracker_2.dto.TaskDto;
import com.spring_boot.task_tracker_2.entity.Task;

public class TaskMapper {

    public TaskDto toDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getOrdinal(),
                task.getCreatedAt());
    }
}
