package jorgejr.list_manager.repository;

import jorgejr.list_manager.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
