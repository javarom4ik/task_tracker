package com.spring_boot.task_tracker_2.controller;

import com.spring_boot.task_tracker_2.dto.ProjectDto;
import com.spring_boot.task_tracker_2.entity.Project;
import com.spring_boot.task_tracker_2.handler.exception.BadRequestException;
import com.spring_boot.task_tracker_2.handler.exception.NotFoundException;
import com.spring_boot.task_tracker_2.mapper.ProjectMapper;
import com.spring_boot.task_tracker_2.repo.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;


    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectMapper.toDto(projectRepository.findAll()));

    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectDto> createProject(@RequestParam String name) {

        projectRepository
                .findByName(name)
                .ifPresent( pj -> {
                    throw new BadRequestException("Project already exists");
                });
        Project project = projectRepository.saveAndFlush(
                Project
                        .builder()
                        .name(name)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(projectMapper.toDto(project));
    }

    @PatchMapping("/projects/{id}")
    public ResponseEntity<ProjectDto> updateProject(@RequestParam String name,
                                                    @PathVariable Long id) {
        Project project = projectRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found"));

        projectRepository
                .findByName(name)
                .filter(anotherProject ->
                        !Objects.equals(id, anotherProject.getId()))
                .ifPresent( pj -> {
                    throw new BadRequestException("Project already exists");
                });
        project.setName(name);
        projectRepository.saveAndFlush(project);
        return ResponseEntity.ok(projectMapper.toDto(project));

    }

    @DeleteMapping("projects/{id}")
    public ResponseEntity<ProjectDto> deleteProject(@PathVariable Long id) {
       Project project = projectRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found"));

       projectRepository.delete(project);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
