package com.scaler.toDoAppWithDb.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TasksRepositoryTests {
    @Autowired private TasksRepository tasksRepository;

    @Test
    public void canCreateTask(){
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setName("task1");
        taskEntity.setDueDate(new Date());
        taskEntity.setDone(false);
        tasksRepository.save(taskEntity);

        TaskEntity savedTask = tasksRepository.findAll().get(0);
        Assertions.assertEquals("task1",tasksRepository.findAll().get(0).getName());

        System.out.println(savedTask.toString());
    }
}
