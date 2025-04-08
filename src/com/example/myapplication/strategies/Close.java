package com.example.myapplication.strategies;

import com.example.myapplication.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Close extends AbstractTaskInteraction {
    @Override
    public ArrayList<Task> handle(ArrayList<Task> tasks, Scanner scanner) {
        System.out.println("Exiting the application. Goodbye!");
        return tasks;
    }
}
