package com.example.myapplication.strategies;

import com.example.myapplication.MenuState;
import com.example.myapplication.Task;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Update extends AbstractTaskInteraction {
    private final int FINALIZEDTASK=100;
    private final int INITIALIZEDTASK=0;
    private boolean isInCompletionRange(int newCompletion) {
        return !(newCompletion >= INITIALIZEDTASK && newCompletion <= FINALIZEDTASK);
    }
    private boolean hasTask(int updateIndex,ArrayList<Task> tasks) {
       return !(updateIndex >= INITIALIZEDTASK && updateIndex < tasks.size());
    }

    @Override
    public ArrayList<Task> handle(ArrayList<Task> tasks, Scanner scanner) {
        System.out.println("Enter the index of task to update(start from 0): ");
        System.out.println("\nCurrent Tasks:");
        //        for(Task i:tasks){
//            System.out.println(i + ": " + tasks);
//        }

        IntStream.range(0, tasks.size()).forEach(i -> {
            System.out.println(i + ": " + tasks.get(i).toString());
        });

        int updateIndex = scanner.nextInt();

        if (hasTask(updateIndex,tasks)) {
            System.out.println("Invalid index. No task updated.");
            return tasks;
        }

        System.out.println("Enter new completion percentage (0-100): ");
        int newCompletion = scanner.nextInt();

        if (isInCompletionRange(newCompletion)) {
            System.out.println("Invalid percentage. Must be between 0 and 100.");
            return tasks;
        }

        tasks.get(updateIndex).Completion = newCompletion;
        System.out.println("Task updated succesfully");

        if (newCompletion == FINALIZEDTASK) {
            System.out.println("Task is Completed");
            System.out.println("Would you like to remove completed task ?  Y/N");
            String answear = scanner.nextLine();

            if (Objects.equals(answear, "Y")) {
                tasks.remove(newCompletion);
            }

        }

        return tasks;
    }
}
