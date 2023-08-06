package com.scaler.toDoAppWithDb.tasks;

import com.scaler.toDoAppWithDb.common.BaseEntity;
import com.scaler.toDoAppWithDb.notes.NoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="due_date",nullable = false)
    private Date dueDate;

    @Column(name = "done", nullable = false, columnDefinition = "boolean default false")
    private boolean done;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    List<NoteEntity> notes;
}
