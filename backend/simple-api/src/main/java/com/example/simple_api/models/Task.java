package com.example.simple_api.models;

public class Task {

    private long id = 0;
    private String title;
    private String description;
    private String status;

    public Task(){

    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "ACTIVE";
    }

    public Task(Long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
