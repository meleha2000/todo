package com.apps.training.todos.controller;

import com.apps.training.todos.entity.SecUser;
import com.apps.training.todos.entity.Todo;
import com.apps.training.todos.service.SecUserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private SecUserService userService;

    @GetMapping("/users-list")
    public String findAllUsers(Model model, @ModelAttribute("msg") String msg){

        List<SecUser> list = userService.findAllUsers();
        model.addAttribute("usersList", list);
        return  "usersList";
    }

    @GetMapping("/users/{username}")
    public String findTodosByUserName(@PathVariable String username , Model model){
        List<SecUser> list = userService.findUserByUserName(username);
        model.addAttribute("usersList", list);
        return "usersList" ;
    }
    @GetMapping("/users/add")
    public String goForm(Model model){
        model.addAttribute("user", new SecUser());
        return "userForm";
    }

    @PostMapping("/users/save")
    public  String save(@Valid @ModelAttribute SecUser user, BindingResult br, Model model) {

        //model.addAttribute("todo", todo);
        System.err.println("@@@@@@ before user ERrrors");
        if (br.hasErrors()) {
            //return  new ModelAndView("redirect:/todos/add");
            System.err.println("@@@@@@ user ERrrors");
            return "userForm";
        }
        //return new ModelAndView("redirect:/todos-list");
        SecUser savedUser = userService.addUser(user);
        model.addAttribute("msg", "todo number " + savedUser.getId() + " is added ..");
        return "redirect:users-list";
    }
    @GetMapping("/user/edit/{id}")
    public String editForm(Model model, @PathVariable int id){
        SecUser user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "userForm";
    }

    @DeleteMapping("/users/remove/{id}")
    public ModelAndView removeTodo(@PathVariable int id) {
        userService.removeUserById(id);
        return new ModelAndView("redirect:/users-list");
    }
}
