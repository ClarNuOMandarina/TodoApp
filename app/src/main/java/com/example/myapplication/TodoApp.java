package com.example.myapplication;

import java.util.ArrayList;
import java.util.Scanner;

class Task{
    String Description;
    int Completion;

    Task (String Description,int Completion){
        this.Description=Description;
        this.Completion=Completion;

    }

    @Override
    public String toString(){
        return "Task" +Description+ " Completion"+Completion+"%";
    }
}

public class TodoApp {
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean DoTasksExist = false;
        int choice = -1;
        while (choice != 0) {
            if(tasks.size()>0){
                DoTasksExist=true;
            }
            else {
                DoTasksExist=false;
            }

            System.out.println("\nToDo App ");
            System.out.println("1. Add Task ");
            if(DoTasksExist) {
                System.out.println("2. Remove Task ");
                System.out.println("3. Update Task Completion ");
                System.out.println("4. List Tasks ");
            }
            System.out.println("0. Exit ");
            System.out.print("Enter your choice:  ");


            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Wrong data type!");
                choice=-1;
            }

           if(!DoTasksExist && choice>1) {
               System.out.println("Invalid Command");
               choice = -1;
           }
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String Description = scanner.nextLine();
                    tasks.add(new Task(Description, 0));
                    System.out.println("Task added succesfully");
                    break;

                case 2:

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
                    } else {
                        System.out.println("Invalid index. No task removed.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the index of task to update(start from 0): ");
                    System.out.println("\nCurrent Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + ": " + tasks.get(i).toString());
                    }
                    int updateIndex = scanner.nextInt();
                    if (updateIndex >= 0 && updateIndex < tasks.size()) {
                        System.out.println("Enter new completion percentage (0-100): ");
                        int newCompletion = scanner.nextInt();
                        if (newCompletion >= 0 && newCompletion <= 100) {
                            tasks.get(updateIndex).Completion = newCompletion;
                            System.out.println("Task updated succesfully");
                            if(newCompletion==100){
                                System.out.println("Task is Completed");
                                System.out.println("Would you like to remove completed task ?  Y/N");
                                String answear = scanner.nextLine();
                                if(answear=="Y"){
                                    tasks.remove(newCompletion);
                                }
                            }
                        } else {
                            System.out.println("Invalid percentage. Must be between 0 and 100.");
                        }
                    } else {
                        System.out.println("Invalid index. No task updated.");
                    }

                case 4:
                    System.out.println("\nCurrent Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + ": " + tasks.get(i).toString());
                    }
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;


            }
        }
        scanner.close();

    }

    public void Case1(){

    }
    public void Case2(){

    }
    public void Case3(){

    }
    public void Case4(){

    }
}

