package jorgejr.list_manager.controller;

import jorgejr.list_manager.model.dto.TaskListInput;
import jorgejr.list_manager.model.entity.TaskList;
import jorgejr.list_manager.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasklist")
public class TaskListController {
    @Autowired
    private TaskListRepository repository;

    @PostMapping
    public ResponseEntity<TaskList> create(@RequestBody TaskListInput input) {

        var taskList = new TaskList(input);
        repository.save(taskList);

        return ResponseEntity.ok(taskList);
    }

   @GetMapping
   public ResponseEntity<List<TaskList>> findAll(){

        var todolists = repository.findAll();

        return ResponseEntity.ok(todolists);
   }

}
