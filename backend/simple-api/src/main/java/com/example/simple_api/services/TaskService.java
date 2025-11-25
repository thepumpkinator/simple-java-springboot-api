package com.example.simple_api.services;


import com.example.simple_api.dto.TaskDTO;
import com.example.simple_api.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.example.simple_api.models.Task;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private Task dtoToModel(TaskDTO dto) throws Exception {
        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setTitle(dto.getTitle());
        return task;
    }

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() throws Exception {
        return taskRepository.getTasks();
    }

    public Task getTask(long id) throws Exception {
        return taskRepository.getTaskById(id);
    }

    public Task createTask(TaskDTO dto) throws Exception {
        return taskRepository.saveTask(dtoToModel(dto));
    }

    public Task updateTask(TaskDTO dto, long id) throws Exception {
        return taskRepository.updateTask(dtoToModel(dto), id);

    }

    public void deleteTaskById(long id) throws Exception {
        taskRepository.deleteTaskById(id);
    }

//    public Task updateTaskStatus(int id, int status) {
//
//    }


}
