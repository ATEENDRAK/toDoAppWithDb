package com.scaler.toDoAppWithDb.tasks;

import com.scaler.toDoAppWithDb.common.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController  {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        var task = tasksService.createNewTask(taskDto);
      //  return ResponseEntity.status(201).body(task);
        return ResponseEntity.created(URI.create("/tasks"+task.getId())).body(task);
    }

    @PatchMapping("")
    public void updateTaskById(){

    }

    @ExceptionHandler({
            TasksService.TaskNotFoundException.class,
            TasksService.TaskInvalidException.class,
            TasksService.TaskAlreadyExistsException.class
    })
    ResponseEntity<ErrorResponseDto> handleError(Exception e){
        HttpStatus errorStatus;
        if(e instanceof TasksService.TaskNotFoundException)
            errorStatus = HttpStatus.NOT_FOUND;
        else if(e instanceof  TasksService.TaskAlreadyExistsException)
            errorStatus = HttpStatus.CONFLICT;
        else if(e instanceof TasksService.TaskInvalidException)
            errorStatus = HttpStatus.BAD_REQUEST;
        else
            errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(errorStatus).body(new ErrorResponseDto(e.getMessage()));
    }
}
