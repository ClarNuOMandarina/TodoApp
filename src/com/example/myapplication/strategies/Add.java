package com.example.myapplication.strategies;

import com.example.myapplication.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Add extends AbstractTaskInteraction {
    @Override
    public ArrayList<Task> handle(ArrayList<Task> tasks, Scanner scanner) {
        System.out.print("Enter task description: ");
        String Description = scanner.nextLine();
        tasks.add(new Task(Description, 0));
        System.out.println("Task added succesfully");
        return tasks;
    }
}
