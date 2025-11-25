package com.example.simple_api.repository;

import com.example.simple_api.models.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
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

    private List<Task> tasks;

    public TaskJSONRepository() throws IOException {
        load();
    }

    private void load() throws IOException {
        if (Files.notExists(file)) {
            tasks = new ArrayList<>();
            save();
        } else {
            tasks = new ArrayList<>(Arrays.asList(mapper.readValue(file.toFile(), Task[].class)));
        }
    }

    private void save() throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(file.toUri()), tasks);
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
        return tasks;
    }

    @Override
    public Task getTaskById(long id) throws Exception {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Task saveTask(Task task) throws Exception {
        try{
            long nextId = tasks.stream().mapToLong(Task::getId).max().orElse(0) + 1;
            task.setId(nextId);
            tasks.add(task);
            save();
        } catch (RuntimeException e) {
           throw new RuntimeException(e);
        }
        return task;
    }

    @Override
    public Task updateTask(Task updated, long id) throws Exception {
        try{
            Task current = getTaskById(id);
            if(current == null) return null;

            current.setDescription(updated.getDescription());
            current.setStatus(updated.getStatus());
            current.setTitle(updated.getTitle());

            save();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    @Override
    public void deleteTaskById(long id) throws Exception {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed) save();
    }
}
