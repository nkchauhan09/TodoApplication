package com.Project.TodoApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.TodoApplication.entities.Todo;
import com.Project.TodoApplication.services.TodoService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> getTodo()
	{
		
		return this.todoService.getTodos();
		
	}
		
	@PostMapping("/todos")
	public ResponseEntity<HttpStatus> addTodo(@RequestBody Todo todo)
	{
		try 
		{
			this.todoService.addTodo(todo);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/todos")
	public ResponseEntity<HttpStatus> updateTodo(@RequestBody Todo todo)
	{
		try
		{
			this.todoService.updateTodo(todo);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("todos/{id}")
	public ResponseEntity<HttpStatus> deleteTodo(@PathVariable String id)
	{
		try 
		{
			this.todoService.deleteTodo(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
