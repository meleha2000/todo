package com.apps.training.todos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.training.todos.entity.Todo;
import com.apps.training.todos.repo.TodoRepo;

import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class TodoService {
	
	private   TodoRepo todoRepo ;
	
	public List<Todo> findAllTodos(){
		return todoRepo.findAll();
	}
	
	public List<Todo> findTodoByUserName(String userName){
		return todoRepo.findByuserName(userName);		
	}
	
	public Todo findTodoById(int id){
		Optional<Todo>  optionalTodo = todoRepo.findById(id);	
		if(optionalTodo.isPresent())
			return optionalTodo.get();
		else
			return null;
	}
	
	public Todo addTodo(Todo todo) {
		Todo addedTodo = todoRepo.save(todo);
		return addedTodo;
		
	}
	
	public Todo updateTodo(Todo todo) {
		Todo updatedTodo = todoRepo.save(todo);
		return updatedTodo;
	}
	
	public void removeTodoById(int id) {
		todoRepo.deleteById(id);
	}
	public void removeTodo(Todo todo) {
		todoRepo.delete(todo);
	}

}
