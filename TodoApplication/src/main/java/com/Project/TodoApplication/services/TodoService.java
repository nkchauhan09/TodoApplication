package com.Project.TodoApplication.services;

import java.util.List;

import com.Project.TodoApplication.entities.Todo;

public interface TodoService {
	
	public List<Todo> getTodos();
	
	public Todo addTodo(Todo todo);

	public Todo updateTodo(Todo todo);

	public void deleteTodo(long parseLong);

}
