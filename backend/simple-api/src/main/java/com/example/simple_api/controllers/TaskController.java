package com.example.simple_api.controllers;

import com.example.simple_api.repository.TaskJSONRepository;
import com.example.simple_api.repository.TaskRepository;
import com.example.simple_api.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.simple_api.models.Task;

@RestController("/")
@RequestMapping()
public class TaskController {


    private final TaskService taskService = new TaskService(new TaskJSONRepository());

    //get one tasks
    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) throws Exception {
        System.out.println("getTask");
        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    //getListOfTasks
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() throws Exception {
        System.out.println("getAllTasks");
        List<Task> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/task/save")
    public ResponseEntity<Task> addTask(@RequestBody Task task) throws Exception {
        System.out.println("addTask");
        Task task = taskService.createTask(task);

    }
//
//    @PutMapping("/task")
//    public ResponseEntity<Task> updateTask() {
//
//    }
//
//
//    @DeleteMapping("/task")
//    public ResponseEntity<Task> deleteTask() {
//
//    }


}
