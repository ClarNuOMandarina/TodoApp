package com.example.myapplication;

public class Task{
    String Description;
    public int Completion;

    public Task(String Description, int Completion){
        this.Description=Description;
        this.Completion=Completion;

    }

    @Override
    public String toString(){
        return "Task" +Description+ " Completion"+Completion+"%";
    }
}
