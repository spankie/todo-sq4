package com.david.todosq4.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public String HealthCheck() {
    return "Our app is running on port:" + port + " with path: " + path;
  }
}