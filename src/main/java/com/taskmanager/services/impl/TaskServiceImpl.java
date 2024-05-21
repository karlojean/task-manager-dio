package com.taskmanager.services.impl;

import com.taskmanager.models.TaskModel;
import com.taskmanager.repositories.TaskRepository;
import com.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Strategy
@Service
public class TaskServiceImpl implements TaskService {

    // Singleton
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<TaskModel> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel findById(Integer id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.get();
    }

    @Override
    public void createTasks(TaskModel task) {
        taskRepository.save(task);
    }

    @Override
    public void update(Integer id, TaskModel task) {
        Optional<TaskModel> taskDb = taskRepository.findById(id);
        if(taskDb.isPresent()) {
            taskRepository.save(task);
        }
    }

    @Override
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}
