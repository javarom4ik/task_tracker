package com.spring_boot.task_tracker_2.handler;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime date,
        String message,
        int status
) {}
