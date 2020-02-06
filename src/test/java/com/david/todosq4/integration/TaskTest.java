package com.david.todosq4.integration;

import com.david.todosq4.controllers.TasksController;
import com.david.todosq4.models.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TaskTest
 */
@SpringBootTest
@AutoConfigureMockMvc // Allows the mockmvc to be autowired for us
public class TaskTest {

  @Autowired
  private TasksController taskController;

  @Autowired
  private MockMvc mockMvc;

  // @Autowired
  // public TaskTest(TasksController taskController, MockMvc mockMvc) {
  // this.mockMvc = mockMvc;
  // this.taskController = taskController;
  // }

  @Test
  public void ContextLoad() {
    assertThat(taskController).isNotNull();
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void CreateTaskWithCorrectValuesTest() throws Exception {
    Task t = new Task("demo1", "demo1 description", "pending");
    this.mockMvc.perform(post("/tasks").contentType(MediaType.APPLICATION_JSON).content(asJsonString(t))).andDo(print())
        .andExpect(status().isCreated()).andExpect(content().string(containsString("demo1 description")));

    // modify the test to not only check part of the json object
  }

}