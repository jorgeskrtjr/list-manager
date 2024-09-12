package jorgejr.list_manager.repository;

import jorgejr.list_manager.model.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
}
