package com.vinodspringboot.todo.todoapp;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoControllerJPA {

    private TodoRepository todoRepository;


    public TodoControllerJPA(TodoService todoService, TodoRepository todoRepository1) {
        this.todoRepository = todoRepository1;
    }

    @RequestMapping("todo-list")
    public String todoList(Model model) {
        List<Todo> todos = todoRepository.findByUsername(getLoggedInUsername());
        model.addAttribute("todos", todos);

        return "todo-list";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String todoForm(ModelMap model) {
        Todo todo = new Todo(0, getLoggedInUsername(), "", LocalDate.now(), false);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        todo.setUsername(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {

        model.addAttribute("todo", todoRepository.getReferenceById(id));
        return "addTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        todo.setUsername(getLoggedInUsername());
//        todoService.updateTodo(todo);
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
