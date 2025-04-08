package com.example.myapplication.strategies;

import com.example.myapplication.MenuState;
import com.example.myapplication.Task;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbstractTaskInteraction {
    public abstract ArrayList<Task> handle(ArrayList<Task> tasks, Scanner scanner);
    public static AbstractTaskInteraction getStrategy(MenuState state){
        try{
            String className=state.name().charAt(0)+state.name().substring(1).toLowerCase();    // ADD->Add
            String fullClassName= STR."com.example.myapplication.strategies.\{className}";                  //Add->Add class location
            Class<?> strategy=Class.forName(fullClassName);                                                 //load Add class
            return (AbstractTaskInteraction) strategy.getDeclaredConstructor().newInstance();               // return new Add class instance
        } catch(Exception e){
            throw new RuntimeException("Strategy not found");
        }

    }
}
