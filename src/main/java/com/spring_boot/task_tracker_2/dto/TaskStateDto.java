package com.spring_boot.task_tracker_2.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStateDto {

    private Long id;

    private String name;

    private String ordinal;

    private LocalDateTime createdAt = LocalDateTime.now();
}
