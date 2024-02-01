package com.drbarzaga.taskapi.services;

import com.drbarzaga.taskapi.entities.TaskEntity;
import com.drbarzaga.taskapi.models.TaskDetail;
import com.drbarzaga.taskapi.models.TaskPostRequest;
import com.drbarzaga.taskapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public int addAll(List<TaskPostRequest> taskPostRequest) {
        // Convert TaskPostRequest to TaskEntity and save to database
        List<TaskEntity> tasks = taskPostRequest.stream().map(task -> {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTitle(task.getTitle());
            taskEntity.setPriority(task.getPriority());
            taskEntity.setDescription(task.getDescription());
            taskEntity.setCreatedBy(task.getCreatedBy());
            return taskEntity;
        }).toList();

        return taskRepository.saveAll(tasks).size();
    }

    public List<TaskDetail> fetchAll() {
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.
                stream()
                .map(task -> new TaskDetail(
                        task.getTitle(),
                        task.getPriority(),
                        task.getDescription(),
                        task.getCreatedBy())
                ).collect(Collectors.toList());
    }

    public List<TaskDetail> fetchByCreatedBy(String createdBy) {
        List<TaskEntity> tasksByCreatedBy =   taskRepository.findAllByCreatedBy(createdBy);

        return tasksByCreatedBy.
                stream()
                .map(task -> new TaskDetail(
                        task.getTitle(),
                        task.getPriority(),
                        task.getDescription(),
                        task.getCreatedBy())
                ).collect(Collectors.toList());
    }

    public List<TaskDetail> subset(String sortBy, String sortDirection, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.valueOf(sortDirection.toUpperCase()), sortBy));

        return taskRepository.findAll(pageable)
                .stream()
                .map(task -> new TaskDetail(
                        task.getTitle(),
                        task.getPriority(),
                        task.getDescription(),
                        task.getCreatedBy())
                ).collect(Collectors.toList());
    }
}
