package com.company;

public class Task {
    private String name;
    private static long taskCount = 1;
    private long id;
    private boolean completed;

    public Task(String taskName){
        name = taskName;
        id = taskCount++;
        completed = false;
    }
    public void completeTask(){
        completed = true;
    }
    public long getID(){
        return id;
    }
    public String toString(){
        String task = name;
        if (completed)
            return "completed: " + task;
        else
            return id + ". " + task;
    }
}