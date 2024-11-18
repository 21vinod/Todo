package com.vinodspringboot.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;

    static {
        todos.add(new Todo(count++, "aws", "learn aws", LocalDate.now(), false));
        todos.add(new Todo(count++, "react", "learn react", LocalDate.now().plusYears(2), false));
    }

    ;

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(new Todo(count++, todo.name, todo.description, todo.targetDate, false));
    }

    public Todo findTodo(int id) {
        Todo todo1 = todos.stream().filter(todo->todo.getId()==id).findFirst().get();
        return todo1;
    }

    public String toString() {
        return todos.toString();
    }

    public void deleteTodo(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(Todo todo) {
        deleteTodo(todo.id);
        addTodo(todo);
        //todos.add(new Todo(count++, name, desc, LocalDate.now().plusYears(1), false));
    }
}
