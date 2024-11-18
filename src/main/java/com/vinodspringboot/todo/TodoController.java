package com.vinodspringboot.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("username")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("todo-list")
    public String todoList(Model model) {
        model.addAttribute("todos", todoService.getTodos());
        return "todo-list";
    }

    @RequestMapping("todo")
    public String todo(ModelMap model) {
        model.addAttribute("todo", todoService.getTodos());
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String todoForm(ModelMap model) {
        Todo todo = new Todo(0, "", "", LocalDate.now(), false);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        todoService.addTodo(todo);
        return "redirect:todo-list";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id, ModelMap model) {
        todoService.deleteTodo(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        model.addAttribute("todo",todoService.findTodo(id));
        return "addTodo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        todoService.updateTodo(todo);
        return "redirect:todo-list";
    }
}
