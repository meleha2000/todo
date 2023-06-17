package com.apps.training.todos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apps.training.todos.entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer> {
	
	public List<Todo> findByuserName(String userName);

}
