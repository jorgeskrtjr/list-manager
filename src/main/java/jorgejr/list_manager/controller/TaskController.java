package jorgejr.list_manager.controller;

import jakarta.transaction.Transactional;
import jorgejr.list_manager.model.dto.TaskInput;
import jorgejr.list_manager.model.entity.Task;
import jorgejr.list_manager.repository.TaskRepository;
import jorgejr.list_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Task> create(@RequestBody TaskInput input){

        var task = service.create(input) ;
        //Melhorar detalhemento saída
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable Long id){

        var task = repository.findById(id);

        return ResponseEntity.ok(task);
    }

    @GetMapping("/list/{taskListId}")
    public List<Task> getTasksByTaskList(@PathVariable Long taskListId) {

        return service.getTasksByTaskListId(taskListId);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Task> update(@RequestBody TaskInput input){
        var task = repository.getReferenceById(input.id());
        task.update(input);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
