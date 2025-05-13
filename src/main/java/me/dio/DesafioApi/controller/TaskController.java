package me.dio.DesafioApi.controller;

import me.dio.DesafioApi.model.Task;
import me.dio.DesafioApi.repository.TaskRepository;
import me.dio.DesafioApi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public List<Task> findAll(){
       return taskService.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task taskToCreate) {
        Task created = taskService.create(taskToCreate);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}/done")
    public Task markAsDone(@PathVariable Long id){
        return taskService.markAsDone(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
         taskService.delete(id);
         return ResponseEntity.noContent().build();
    }

}
