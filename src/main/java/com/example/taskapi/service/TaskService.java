package com.example.taskapi.service;

import com.example.taskapi.model.Task;
import com.example.taskapi.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Dependência pelo construtor
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task criar(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tarefa com id " + id + " não encontrada"));
    }

    public Task atualizar(Long id, Task dadosAtualizados) {
        Task task = buscarPorId(id); // reaproveita a validação de existência

        task.setTitulo(dadosAtualizados.getTitulo());
        task.setDescricao(dadosAtualizados.getDescricao());
        task.setConcluida(dadosAtualizados.isConcluida());

        return taskRepository.save(task);
    }

    public void excluir(Long id) {
        Task task = buscarPorId(id); // garante que existe antes de excluir
        taskRepository.delete(task);
    }
}
