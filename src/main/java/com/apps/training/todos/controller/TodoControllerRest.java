package com.apps.training.todos.controller;

import com.apps.training.todos.entity.Todo;
import com.apps.training.todos.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class TodoControllerRest {
	
	@Autowired
	private   TodoService todoService;
	
	@GetMapping("/todos-list")
	public List<Todo> findAllTodos(){
		return todoService.findAllTodos();		
	}
	
	@GetMapping("/todos/{username}")
	public List<Todo> findTodosByUserName(@PathVariable  String username ){
		return todoService.findTodoByUserName(username);		
	}
	
	@PostMapping("/todos/add")	
	public  ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		Todo savedTodoo = todoService.addTodo(todo);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/todos/{id}")
                .buildAndExpand(todo.getId()).toUri();
		return ResponseEntity.created(location).body(savedTodoo);
				//new ResponseEntity<Todo> (savedTodoo, HttpStatus.CREATED );		
	}
	
	@DeleteMapping("/todos/remove/{id}")
	public void removeTodo(@PathVariable int id) {
		todoService.removeTodoById(id);
	}
	
	@DeleteMapping("/todos/remove")
	public void removeTodo(@RequestBody Todo todo) {
		todoService.removeTodo(todo);
	}
	

}
