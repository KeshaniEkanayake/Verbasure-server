package com.example.verbasure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.verbasure.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
    
}
