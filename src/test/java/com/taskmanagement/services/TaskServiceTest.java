package com.taskmanagement.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.task.models.Task;
import com.task.repositories.TaskRepository;
import com.task.services.TaskService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        task = new Task("Sample Task", "Task Description");
        task.setId(1L);
        task.setCompleted(false);
    }


    @Test
    public void testGetTaskById() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        Task foundTask = taskService.getTaskById(1L);
        assertThat(foundTask).isNotNull();
        assertThat(foundTask.getTitle()).isEqualTo("Sample Task");
    }

    @Test
    public void testCreateTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        Task createdTask = taskService.createTask(task);
        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getTitle()).isEqualTo("Sample Task");
    }

    @Test
    public void testUpdateTask() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        Task updatedTask = taskService.updateTask(1L, task);
        assertThat(updatedTask).isNotNull();
        assertThat(updatedTask.getTitle()).isEqualTo("Sample Task");
    }

    @Test
    public void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(anyLong());
        taskService.deleteTask(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(List.of(task));
        List<Task> tasks = taskService.getAllTasks();
        assertThat(tasks).hasSize(1);
        assertThat(tasks.get(0).getTitle()).isEqualTo("Sample Task");
    }
}
