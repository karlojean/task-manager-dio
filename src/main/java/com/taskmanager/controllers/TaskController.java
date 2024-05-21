package com.taskmanager.controllers;

import com.taskmanager.models.TaskModel;
import com.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Iterable<TaskModel>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel task ) {
        taskService.createTasks(task);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> update(@PathVariable Integer id, @RequestBody TaskModel task) {
        taskService.update(id, task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}
