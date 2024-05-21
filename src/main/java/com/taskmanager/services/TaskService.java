package com.taskmanager.services;

import com.taskmanager.models.TaskModel;

public interface TaskService {

    Iterable<TaskModel> getAll();

    TaskModel findById(Integer id);

    void createTasks(TaskModel task);

    void update(Integer id, TaskModel task);

    void delete(Integer id);

}
