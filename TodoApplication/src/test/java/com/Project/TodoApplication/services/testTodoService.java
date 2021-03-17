package com.Project.TodoApplication.services;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Project.TodoApplication.Dao.TodoDao;
import com.Project.TodoApplication.entities.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testTodoService {
	
	@Autowired
	private TodoService todoService;
	
	@MockBean
	private TodoDao todoDao;
	
	@Test
	public void testGetTodos()
	{
		Todo todo  = new Todo();
		todo.setName("Breakfast");
		todo.setDone(false);
		
		Todo todo1 = new Todo();
		todo1.setName("Bath");
		todo1.setDone(false);
		
		List<Todo> todoList = new ArrayList<>();
		todoList.add(todo);
		todoList.add(todo1);
		
		Mockito.when(todoDao.findAll()).thenReturn(todoList);
		assertEquals(todoList, todoService.getTodos());
	}
	
	@Test
	public void testAddTodo()
	{
		Todo todo = new Todo();
		todo.setName("Dinner");
		todo.setDone(false);
		
		Mockito.when(todoDao.save(todo)).thenReturn(todo);
		assertEquals(todo, todoService.addTodo(todo));
	}
	
//	@Test
//	public void testUpdateTodo()
//	{
//		Todo todo = new Todo();
//		todo.setId(1l);
//		todo.setName("breakfast");
//		todo.setDone(false);
//		
//		Mockito.when(todoDao.findOne(1l)).thenReturn(todo);
//		todo.setName("bath");
//		Mockito.when(todoDao.save(todo)).thenReturn(todo);
//		assertEqual(todo, todoService.updateTodo(1, "breakfast"));
//	}
//	
//	@Test
//	public void testDeleteTodo()
//	{
//		Todo todo = new Todo();
//		todo.setId(1l);
//		todo.setName("Gym");
//		todo.setDone(false);
//		
//		Mockito.when(todoDao.findOne(1l)).thenReturn(todo);
//		Mockito.when(todoDao.existsById(todo.getId())).thenReturn(false);
//		assertFalse(todoDao.existsById(todo.getId()));
//	}

}
