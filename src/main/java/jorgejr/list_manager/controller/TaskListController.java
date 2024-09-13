package jorgejr.list_manager.controller;

import jorgejr.list_manager.model.dto.TaskListInput;
import jorgejr.list_manager.model.entity.TaskList;
import jorgejr.list_manager.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
