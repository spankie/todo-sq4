package com.david.todosq4.repository;

import com.david.todosq4.models.Task;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TaskRepository
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
  // public Task findByStatus();
}