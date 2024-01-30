package com.drbarzaga.taskapi.controllers;

import com.drbarzaga.taskapi.models.TaskDetail;
import com.drbarzaga.taskapi.models.TaskPostRequest;
import com.drbarzaga.taskapi.models.TaskPostResponse;
import com.drbarzaga.taskapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskPostResponse createTask(@RequestBody List<TaskPostRequest> taskPostRequest) {
       int insertedTasks = taskService.addAll(taskPostRequest);
       TaskPostResponse taskPostResponse = new TaskPostResponse();
       taskPostResponse.setInsertedRecords(insertedTasks);

       return taskPostResponse;
    }

    @GetMapping
    public List<TaskDetail> getTasks() {
       return taskService.fetchAll();
    }

    @GetMapping("/{user}")
    public List<TaskDetail> getUserTasks(@PathVariable String user) {
        return  taskService.fetchByCreatedBy(user);
    }

    @GetMapping("/subset")
    public List<TaskDetail> subset(
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize){

        return taskService.subset(sortBy, sortDirection, page, pageSize);
    }
}
