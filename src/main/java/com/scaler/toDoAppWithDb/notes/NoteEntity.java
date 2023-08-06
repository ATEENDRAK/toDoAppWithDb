package com.scaler.toDoAppWithDb.notes;


import com.scaler.toDoAppWithDb.common.BaseEntity;
import com.scaler.toDoAppWithDb.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity extends BaseEntity {

    @Column(name="title",nullable = false,length =100)
    private String title;

    @Column(name = "body",nullable = false,length =1000)
    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    TaskEntity task;
}
