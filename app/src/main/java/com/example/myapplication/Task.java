package com.example.myapplication;

public class Task {
    String description;
    int completion;
    public Task(String description) {
        this.description = description;
        this.completion = 0;
    }
    @Override
    public String toString() {
        return description + " (" + completion + "%)";
    }
}
