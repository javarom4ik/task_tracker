package com.spring_boot.task_tracker_2.mapper;

import com.spring_boot.task_tracker_2.dto.ProjectDto;
import com.spring_boot.task_tracker_2.entity.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectMapper {

    public ProjectDto toDto(Project project) {
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getCreatedAt());
    }

    public List<ProjectDto> toDto(List<Project> project) {
        return project
                .stream()
                .map(entity -> toDto(entity)).toList();
    }
}
