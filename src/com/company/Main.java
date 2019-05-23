package com.company;

import java.util.*;

/**
 *  Very basic Task manager I made during the 2018-19 summer break over a couple of hours
 *
 *  Commands can be entered into the terminal to add or remove tasks etc.
 */
public class Main {
    private Map<String, Task> taskMap;

    private Main() {
        taskMap = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        toDoList(sc);
    }

    private void addTask(String name) {
        if (taskMap.containsKey(name)) {
            System.out.println(name + " already in tasks");
            return;
        }
        taskMap.put(name, new Task(name));
        System.out.println("Task added: " + name);
    }

    private void removeTask(String name) {
        if (taskMap.containsKey(name)) {
            taskMap.remove(name);
            System.out.println("Removed: " + name);
        } else {
            System.out.println(name + " not found in tasks");
        }
    }

    private void completeTask(String name) {
        if (taskMap.containsKey(name)) {
            taskMap.get(name).completeTask();
            System.out.println(taskMap.get(name));
        }
        else
            System.out.println(name + " not found in tasks");
    }

    private void listAll() {
        if (taskMap.values().isEmpty()) {
            System.out.println("No tasks have been added yet");
            return;
        }
        for (Task t:taskMap.values()) {
            System.out.println(t);
        }
    }

    private void help() {
        System.out.println("Enter in a command followed by tasks which are split by whitespace characters (as shown beneath):");
        System.out.println("COMMAND task1 task2 ...");
        System.out.println("Commands are:\n list , add , remove , complete , help , exit");
    }

    private void toDoList(Scanner sc) {
        help();
        while (true) {
            String command = sc.next();
            String[] tasks = sc.nextLine().trim().split("\\s+");
            switch (command) {
                case "list":
                    listAll();
                    break;
                case "add":
                    for (String task : tasks) {
                        addTask(task);
                    }
                    break;
                case "remove":
                    for (String task : tasks) {
                        removeTask(task);
                    }
                    break;
                case "complete":
                    for (String task : tasks) {
                        completeTask(task);
                    }
                    break;
                case "help":
                    help();
                    break;
                case "exit":
                    System.out.println("Finished");
                    System.exit(1);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
