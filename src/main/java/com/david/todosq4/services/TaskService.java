package com.david.todosq4.services;

import java.util.List;
import java.util.Optional;

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
    Optional<Task> ot = taskRespository.findById(id);
    if (ot.isPresent()) {
      return ot.get();
    } else {
      return null;
    }
  }

  public List<Task> findByStatus(String status) {
    return taskRespository.findByStatus(status);
  }

  public List<Task> getAllTasks() {
    return taskRespository.findAll();
  }
}