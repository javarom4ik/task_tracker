package com.spring_boot.task_tracker_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;

    private String name;

    private String description;

    private String ordinal;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
