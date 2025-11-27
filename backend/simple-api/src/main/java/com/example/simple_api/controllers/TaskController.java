package com.example.simple_api.controllers;

import com.example.simple_api.dto.TaskDTO;
import com.example.simple_api.repository.TaskJSONRepository;
import com.example.simple_api.repository.TaskRepository;
import com.example.simple_api.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import com.example.simple_api.models.Task;

@CrossOrigin(origins = "http://localhost:5173")
@RestController("/")
@RequestMapping()
public class TaskController {

    private final TaskService taskService = new TaskService(new TaskJSONRepository());

    public TaskController() throws IOException {
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) throws Exception {
        System.out.println("getTask");
        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() throws Exception {
        System.out.println("getAllTasks");
        List<Task> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/task/save")
    public ResponseEntity<Task> addTask(@Valid @RequestBody TaskDTO dto) throws Exception {
        System.out.println("addTask");
        Task task = taskService.createTask(dto);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @Valid @RequestBody TaskDTO dto) throws Exception {
        System.out.println("updateTask");
        Task task = taskService.updateTask(dto, id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable long id) throws Exception {
        System.out.println("deleteTask");
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }
}
