package com.david.todosq4.controllers;

import com.david.todosq4.models.Task;
import com.david.todosq4.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TasksController
 */
@RestController
@RequestMapping("/tasks")
public class TasksController {
  @Value("${server.por:40}")
  private String port;
  @Value("${server.servlet.context-path}")
  private String path;

  @Autowired
  private TaskService taskService;

  @GetMapping
  public String HealthCheck() {
    return "Our app is running on port:" + port + " with path: " + path;
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    // System.out.println("logs: " + task.title);
    Task t = taskService.createTask(task);
    HttpStatus statusCode = HttpStatus.CREATED;
    if (t == null) {
      statusCode = HttpStatus.BAD_REQUEST;
    }
    return new ResponseEntity<>(t, statusCode);
  }
}