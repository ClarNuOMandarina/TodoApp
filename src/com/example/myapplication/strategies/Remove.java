package com.example.myapplication.strategies;

import com.example.myapplication.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove extends AbstractTaskInteraction {
    @Override
    public ArrayList<Task> handle(ArrayList<Task> tasks, Scanner scanner) {
        System.out.println("\nCurrent Tasks: ");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i).toString());
        }

        System.out.print("Enter the index of the task to remove(start from 0): ");

        int removeIndex = scanner.nextInt();
        scanner.nextLine();

        if (removeIndex >= 0 && removeIndex < tasks.size()) {
            tasks.remove(removeIndex);
            System.out.println("Task removed successfully.");
            return tasks;
        }

        System.out.println("Invalid index. No task removed.");
        return tasks;
    }
}
