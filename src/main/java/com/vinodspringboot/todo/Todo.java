package com.vinodspringboot.todo;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Todo {
    public int id;
    @Size(min = 3, message="enter at least 3 characters")
    public String name;
    @Size(min = 5,message = "Enter at least 5 characters")
    public String description;
    public LocalDate targetDate;
    public boolean done;

    public Todo(int id, String name, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", description=" + description + ", targetDate=" + targetDate + ", done=" + done + "]";
    }
}
