package com.example.myapplication;

public class Task {
    String description;
    int completion;
    boolean IsCompleted;
    public Task(String description) {
        this.description = description;
        this.completion = 0;
        this.IsCompleted=false;
    }
    @Override
    public String toString() {
        return description + " (" + completion + "%)               "+"task completed:"+IsCompleted;
    }
}
