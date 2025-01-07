package com.task.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.task.models.Task;
import com.task.repositories.TaskRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Sample Task", "Task Description");
        taskRepository.save(task);
    }

    @Test
    public void testFindById() {
        Optional<Task> foundTask = taskRepository.findById(task.getId());
        assertThat(foundTask).isPresent();
        assertThat(foundTask.get().getTitle()).isEqualTo("Sample Task");
    }

    @Test
    public void testSaveTask() {
        Task newTask = new Task("New Task", "New Task Description");
        Task savedTask = taskRepository.save(newTask);
        assertThat(savedTask.getId()).isNotNull();
        assertThat(savedTask.getTitle()).isEqualTo("New Task");
    }

    @Test
    public void testDeleteTask() {
        taskRepository.delete(task);
        Optional<Task> deletedTask = taskRepository.findById(task.getId());
        assertThat(deletedTask).isNotPresent();
    }

    @Test
    public void testFindAllTasks() {
        Iterable<Task> tasks = taskRepository.findAll();
        assertThat(tasks).hasSize(1);
    }
}
