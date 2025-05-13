package me.dio.DesafioApi.service.impl;

import me.dio.DesafioApi.model.Task;
import me.dio.DesafioApi.repository.TaskRepository;
import me.dio.DesafioApi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findByDescription(String description) {
        return taskRepository
                .findAll()
                .stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }

    @Override
    public  Task create(Task taskToCreate) {
       if (taskRepository.existsByDescription(taskToCreate.getDescription())){
           throw new RuntimeException("Já existe uma tarefa com essa descrição!");
       }
       return taskRepository.save(taskToCreate);
    }

    @Override
    public Task delete(Long id) {
        if(!taskRepository.existsById(id)){
            throw new RuntimeException("Não existe tarefa com esse id para ser excluída");
        }
        taskRepository.deleteById(id);
        return null;
    }

    @Override
    public Task markAsDone(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setDone(true);
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrada tarefa com esse id"));
    }
}
