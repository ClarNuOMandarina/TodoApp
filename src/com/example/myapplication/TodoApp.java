package com.example.myapplication;


import com.example.myapplication.strategies.AbstractTaskInteraction;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class TodoApp {
    static ArrayList<Task> tasks = new ArrayList<>();

    public static boolean hasTasks() {
        return !tasks.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuState choice = MenuState.CHOOSING;

        while (choice == MenuState.CHOOSING) {
            System.out.println("\nToDo App ");
            System.out.println("1. Add Task ");
            if (hasTasks()) {
                System.out.println("2. Remove Task ");
                System.out.println("3. Update Task Completion ");
                System.out.println("4. List Tasks ");
            }

            System.out.println("0. Exit ");
            System.out.print("Enter your choice:  ");

            try {
                choice = MenuState.fromValue(scanner.nextInt());

                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Wrong data type!");
                choice = MenuState.CHOOSING;
            }

            if (!hasTasks() && choice.getValue() > 1) {
                System.out.println("Invalid Command");
                choice = MenuState.CHOOSING;
            }

            AbstractTaskInteraction taskInteraction = AbstractTaskInteraction.getStrategy(choice);
            tasks=taskInteraction.handle(tasks,scanner);;
        }
        scanner.close();

    }
}

