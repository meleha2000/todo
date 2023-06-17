package com.apps.training.todos.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.apps.training.todos.entity.Todo;
import com.apps.training.todos.service.TodoService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TodoController {
	
	@Autowired
	private  final  TodoService todoService;

	@GetMapping("/")
	public String mainPage(){
		return "welcome";
	}

	@GetMapping("/todos-list")
	public String findAllTodos(Model model, @ModelAttribute("msg") String msg){

		List<Todo> list = todoService.findAllTodos();
		model.addAttribute("todosList", list);
		return  "todosList";
	}
	
	@GetMapping("/todos/{username}")
	public String findTodosByUserName(@PathVariable  String username , Model model){
		List<Todo> list = todoService.findTodoByUserName(username);
		model.addAttribute("todosList", list);
		return "todosList" ;
	}
	@GetMapping("/todos/add")
	public String goForm(Model model){
		model.addAttribute("todo", new Todo());
		return "todoForm";
	}
	
	@PostMapping("/todos/save")
	public  String save(  @Valid @ModelAttribute Todo todo,  BindingResult br, Model model) {

		//model.addAttribute("todo", todo);
		System.err.println("@@@@@@ before ERrrors");
		if (br.hasErrors()) {
			//return  new ModelAndView("redirect:/todos/add");
			System.err.println("@@@@@@ ERrrors");
			return "todoForm";
		}
		//return new ModelAndView("redirect:/todos-list");
		Todo savedTodo = todoService.addTodo(todo);
		model.addAttribute("msg", "todo number " + savedTodo.getId() + " is added ..");
		return "redirect:todos-list";
	}
   @GetMapping("/todo/edit/{id}")
	public String editForm(Model model, @PathVariable int id){
		Todo todo = todoService.findTodoById(id);
		model.addAttribute("todo", todo);
		return "todoForm";
	}
	
	@DeleteMapping("/todos/remove/{id}")
	public ModelAndView removeTodo(@PathVariable int id) {
		todoService.removeTodoById(id);
		return new ModelAndView("redirect:/todos-list");
	}
}
