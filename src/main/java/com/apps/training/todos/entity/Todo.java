package com.apps.training.todos.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "todo")
@Getter
@Setter
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 10, message = "Enter at least 10 char")
	@NotNull(message = "it must be not null")
	@NotEmpty(message = "it must be not empty")
	@Column(name = "description", length = 350, nullable = false, updatable = true, insertable = true)
	private String description;
	
	@Column(name = "todo_date",  nullable = false, updatable = true, insertable = true)
	private LocalDate todoDate;
	@Column(name = "user_name", length = 100, nullable = false, updatable = true, insertable = true)
	private String userName;
	
	@Column(name = "status", length = 50, nullable = false, updatable = true, insertable = true)
	private String status;

}
