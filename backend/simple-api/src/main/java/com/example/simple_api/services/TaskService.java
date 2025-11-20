package com.example.simple_api.services;


import com.example.simple_api.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.example.simple_api.models.Task;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() throws Exception {
        return taskRepository.getTasks();
    }

    public Task getTask(long id) throws Exception {
        return taskRepository.getTaskById(id);
    }

    public Task createTask(Object task) throws Exception {


    }

//    public Task updateTask() {
//
//    }
//
//    public Task updateTaskStatus(int id, int status) {
//
//    }


}
