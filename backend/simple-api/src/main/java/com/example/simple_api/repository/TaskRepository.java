package com.example.simple_api.repository;

import java.util.List;
import com.example.simple_api.models.Task;

public interface TaskRepository {
    List<Task> getTasks() throws Exception;
    Task getTaskById(long id) throws Exception;
    Task saveTask(Task task) throws Exception;
    void deleteTaskById(long id) throws Exception;
}
