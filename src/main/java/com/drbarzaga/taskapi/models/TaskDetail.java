package com.drbarzaga.taskapi.models;

public class  TaskDetail {
    private String title;
    private int priority;// 1-5
    private String description;
    private String createdBy;

    public TaskDetail() {
    }

    public TaskDetail(String title, int priority, String description, String createdBy) {
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.createdBy = createdBy;
    }

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
        return "TaskDetail{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
