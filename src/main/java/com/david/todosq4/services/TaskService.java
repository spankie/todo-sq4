package com.david.todosq4.services;

import com.david.todosq4.models.Task;
import com.david.todosq4.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TaskService
 */
@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRespository;

  public Task createTask(Task task) {
    Task t = null;
    try {
      t = taskRespository.save(task);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
    return t;
  }

  public Task getATask(Integer id) {
    return taskRespository.getOne(id);
  }
}