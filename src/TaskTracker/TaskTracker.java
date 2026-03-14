package TaskTracker;

import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args) {
        System.out.println("Hi! I'm task tracker");

        Scanner userInput = new Scanner(System.in);

        System.out.println("Fill in the following data");

        System.out.println("1. Task name");
        String taskTitle = userInput.nextLine();

        System.out.println("2. Task description");
        String taskDescription = userInput.nextLine();

        System.out.println("3. Task priority");
        int taskPriority = userInput.nextInt();

        System.out.printf("Info about the task \nTitle: %s \nDescription: %s \nPriority: %d\n", taskTitle, taskDescription, taskPriority);
    }
}
