package com.example.simple_api.repository;

import com.example.simple_api.models.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
@Primary
public class TaskJSONRepository implements TaskRepository {

    private final Path file = Paths.get("data/task.json");

    private final ObjectMapper mapper = new ObjectMapper();


    public List<Task> readJSON() {
        try{
            if(Files.notExists(file)) return new ArrayList<>();
            return Arrays.asList(mapper.readValue(file.toFile(), Task[].class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Task findTaskById(long id, List<Task> tasks) throws Exception{
        Task task = null;
        for(Task t: tasks){
            if(t.getId() == id){
                task = t;
            }
        }
        return task;
    }


    @Override
    public List<Task> getTasks() throws Exception {
        return this.readJSON();
    }

    @Override
    public Task getTaskById(long id) throws Exception {
        return this.findTaskById(id, this.readJSON());
    }

    @Override
    public Task saveTask(Task task) throws Exception {
        List<Task> tasks = getTasks();
        tasks.add(task);

        try{
            mapper.writeValue(file.toFile(), tasks);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    @Override
    public void deleteTaskById(long id) throws Exception {

    }
}
