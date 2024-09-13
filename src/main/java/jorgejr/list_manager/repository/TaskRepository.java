package jorgejr.list_manager.repository;

import jorgejr.list_manager.model.entity.Task;
import jorgejr.list_manager.model.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskList(TaskList tasklist);

    List<Task> findByTaskListId(Long id);
}
