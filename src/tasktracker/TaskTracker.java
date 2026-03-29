package tasktracker;

/*
 Изначально было решение через просто массив размером на 10 элементов, но с ним работать не так удобно, как с
 динамическим ArrayList
 static Task[] tasks1 = new Task[10];
 static int taskCount = 0;

*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskTracker {
    static ArrayList<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args) throws IOException {
          /*
        1. Create task model
        2. Show the menu
            2.1 create method that show the menu
        3. if input = 1 --> start creating Task flow
            3.1 created task should be added to the array
            3.2 show menu again
        4. if input = 2 --> Print all tasks stored in array
            4.1 show menu again
        5. if input = 0 --> finish the program

        1. Создать конструктор для enum
            1a. Причесать строку, которую юзер вводит
        2. Создать метод, который переводит значение enum в строку
        3. Если юзер неверно ввел статус --> попросить снова
         */

        while (true) {
            showMenu();
            int userInput = getUserInput();
            if (userInput == 1) {
                Task task = createTask();
                tasks.add(task);
                writeTasksToFile();
            } else if (userInput == 2) {
                printAllTasks();
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("Select an option:");
        System.out.println("1 - Input the task");
        System.out.println("2 - Display all tasks");
        System.out.println("0 - Exit");
    }

    public static int getUserInput() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }

    public static Task createTask() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Fill in the following data");

        System.out.println("1. Task name");
        String taskName = userInput.nextLine();

        System.out.println("2. Task description");
        String taskDescription = userInput.nextLine();

        System.out.println("3. Task priority");

        int taskPriority = 0;
        try {
            taskPriority = userInput.nextInt();
            userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You should enter a number");
            userInput.nextLine();
        }

        Status taskStatus;
        do {
            System.out.println("4. Task status (Open, In Progress, Ready For Test, In Test, Closed)");
            taskStatus = Status.makeFromUserInput(userInput.nextLine());
        } while (taskStatus == null);

        return new Task(taskName, taskDescription, taskPriority, taskStatus);
    }

    public static void printAllTasks() {
        for (Task task : tasks) {
            System.out.printf("Info about the task: \nTitle: %s \nDescription: %s \nPriority: %d \nStatus: %s",
                    task.getName(), task.getDescription(), task.getPriority(), task.getStatus().convertToString());
        }
    }

    public static String getDataForFileWriter(Task task) {
        return String.format("%s/%s/%d/%s", task.getName(), task.getDescription(), task.getPriority(),
                task.getStatus().convertToString());
    }

    public static void writeTasksToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("/Users/alenap/tasks.txt", false)) {
            for (Task task : tasks) {
                fileWriter.write(getDataForFileWriter(task) + "\n");
            }
        }
    }
}
