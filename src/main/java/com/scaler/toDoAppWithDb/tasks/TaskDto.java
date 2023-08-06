package com.scaler.toDoAppWithDb.tasks;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    @Nullable
    Long id;
    @Nullable
    private String name;
    @Nullable
    private Date dueDate;
    @Nullable
    private Boolean done;
}
