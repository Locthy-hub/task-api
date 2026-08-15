package com.example.taskapi.controller;

import com.example.taskapi.model.Task;
import com.example.taskapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    // Dependência pelo construtor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // POST /tasks -> cria uma nova tarefa
    @PostMapping
    public ResponseEntity<Task> criar(@RequestBody Task task) {
        Task novaTask = taskService.criar(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTask);
    }

    // GET /tasks -> lista todas as tarefas
    @GetMapping
    public List<Task> listar() {
        return taskService.listarTodas();
    }

    // GET /tasks/{id} -> busca uma tarefa pelo id
    @GetMapping("/{id}")
    public Task buscarPorId(@PathVariable Long id) {
        return taskService.buscarPorId(id);
    }

    // PUT /tasks/{id} -> atualiza uma tarefa existente
    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @RequestBody Task task) {
        return taskService.atualizar(id, task);
    }

    // DELETE /tasks/{id} -> exclui uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        taskService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
