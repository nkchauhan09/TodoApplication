package com.Project.TodoApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.TodoApplication.Dao.TodoDao;
import com.Project.TodoApplication.entities.Todo;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDao todoDao;

	@Override
	public List<Todo> getTodos() {
		return todoDao.findAll();
	}

	@Override
	public Todo addTodo(Todo todo) {
		todoDao.save(todo);
		return todo;
	}

	@Override
	public Todo updateTodo(Todo todo) {
		todoDao.save(todo);
		return todo;
	}

	@Override
	public void deleteTodo(long parseLong) {
		Todo entity = todoDao.getOne(parseLong);
		todoDao.delete(entity);	
	}

}
