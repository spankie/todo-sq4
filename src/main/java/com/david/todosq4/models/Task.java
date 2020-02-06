package com.david.todosq4.models;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

/**
 * Task
 */
@Entity
@Table(name = "tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @NotNull
  @Length(max = 150)
  private String title;
  private String description;
  // @JsonAlias({ "stats", "statuses" })
  private String status;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false)
  private Time createdAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Time getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Time createdAt) {
    this.createdAt = createdAt;
  }

  public Task() {
  }

  public Task(String title, String description, String status) {
    this.title = title;
    this.description = description;
    this.status = status;
  }

}