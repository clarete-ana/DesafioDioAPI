package me.dio.DesafioApi.service;

import me.dio.DesafioApi.model.Task;

import java.util.List;


public interface TaskService {

    List<Task> findAll();

    Task findByDescription(String description);

     Task create(Task taskToCreate);

    Task delete(Long id);

    Task markAsDone(Long id);

    Task findById(Long id);
}
