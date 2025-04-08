package com.example.myapplication.strategies;

import com.example.myapplication.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Show extends AbstractTaskInteraction {
    @Override
    public ArrayList<Task> handle(ArrayList<Task> tasks, Scanner scanner) {
        System.out.println("\nCurrent Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i).toString());
        }

        return tasks;
    }
}
