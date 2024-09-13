package jorgejr.list_manager.service;

import jorgejr.list_manager.model.dto.TaskInput;
import jorgejr.list_manager.model.entity.Task;
import jorgejr.list_manager.model.entity.TaskList;
import jorgejr.list_manager.repository.TaskListRepository;
import jorgejr.list_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskrepository;
    @Autowired
    private TaskListRepository tasklistRepository;
    public Task create(TaskInput input){

        var taskList = tasklistRepository.findById(input.id())
                .orElseThrow(() -> new RuntimeException("TaskList not found"));;

        var task = new Task(input);

        task.setTaskList(taskList);

        taskrepository.save(task);

        return task;
    }

    public List<Task> getTasksByTaskListId(Long taskListId){

        TaskList taskList = tasklistRepository.findById(taskListId)
                .orElseThrow(() -> new RuntimeException("tasklist not found"));

        return taskrepository.findByTaskList(taskList);
    }


}
