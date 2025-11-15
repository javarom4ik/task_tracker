package com.spring_boot.task_tracker_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String ordinal;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany
    @JoinColumn(name = "task_state_id", referencedColumnName = "id")
    private List<Task> tasks = new ArrayList<>();

}
