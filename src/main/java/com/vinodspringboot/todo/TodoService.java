package com.vinodspringboot.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;
    static {
        todos.add(new Todo(count++, "aws", "learn aws", LocalDate.now(), false));
        todos.add(new Todo(count++, "react", "learn react", LocalDate.now().plusYears(2), false));
    };

    public List<Todo> getTodos() {
        return todos;
    }
    public  void addTodo(String name,String desc) {
        todos.add(new Todo(count++,name,desc,LocalDate.now().plusYears(1),false));
    }
    public List<Todo> searchTodo(Todo todo) {
        return todos;
    }
    public String toString() {
        return todos.toString();
    }
}
