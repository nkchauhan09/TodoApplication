package com.Project.TodoApplication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.TodoApplication.entities.Todo;

public interface TodoDao extends JpaRepository<Todo, Long>{
}
