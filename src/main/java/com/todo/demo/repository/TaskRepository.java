package com.todo.demo.repository;

import com.todo.demo.common.Status;
import com.todo.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByTitleContainingIgnoreCase(String title);

    int countTaskByStatus(Status status);

}
