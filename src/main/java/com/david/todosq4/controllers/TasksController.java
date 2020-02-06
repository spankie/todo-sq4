package com.david.todosq4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.david.todosq4.models.Task;
import com.david.todosq4.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public MyResponse<Task> createTask(@RequestBody Task task, HttpServletResponse response) {
    System.out.println("logs: " + task.getTitle());
    Task t = taskService.createTask(task);
    HttpStatus statusCode = HttpStatus.CREATED;
    String message = "Todo created successfully";
    if (t == null) {
      statusCode = HttpStatus.BAD_REQUEST;
      message = "Common get out with your bad request!!!";
    }
    response.setStatus(statusCode.value());
    return new MyResponse<>(statusCode, message, t);
  }

  @GetMapping
  @RequestMapping("{id}") // /api/v1/tasks/
  public MyResponse<Task> getOneTask(@PathVariable Integer id) {
    System.out.printf("id: %d\n", id);
    Task t = taskService.getATask(id);
    if (t == null) {
      return new MyResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "No task with this id: " + id, t);
    }
    return new MyResponse<>(HttpStatus.OK, "Retrieved task successfully", t);
  }

  @GetMapping
  @RequestMapping("/status/{status}")
  public MyResponse<List<Task>> getOneTask(@PathVariable String status) {
    List<Task> t = taskService.findByStatus(status);
    return new MyResponse<>(HttpStatus.OK, "Retrieved tasks successfully", t);
  }
}