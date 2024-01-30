package com.drbarzaga.taskapi.models;

public class TaskPostRequest {
    private String title;
    private int priority;// 1-5
    private String description;
    private String createdBy;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "TaskPostRequest{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
