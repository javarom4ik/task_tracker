package com.spring_boot.task_tracker_2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private List<TaskState> taskStates = new ArrayList<>();


}
