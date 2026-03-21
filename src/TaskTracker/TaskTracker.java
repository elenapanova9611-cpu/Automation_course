package TaskTracker;

/*
 Изначально было решение через просто массив размером на 10 элементов, но с ним работать не так удобно, как с
 динамическим ArrayList
 static Task[] tasks1 = new Task[10];
 static int taskCount = 0;
*/

import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {
   static ArrayList<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args) {
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
         */

        //что если массив фиксированный, пересмотреть презы и value/ref type

        while (true) {
            showMenu();
            int userInput = getUserInput();
            if (userInput == 1) {
                tasks.add(createTask());
            } else if (userInput == 2) {
                printAllTasks();
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Wrong choice, please try again");
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
        int taskPriority = userInput.nextInt();

        return new Task(taskName, taskDescription, taskPriority);
    }

    public static void printAllTasks() {
        for (Task task : tasks) {
                System.out.printf("Info about the task: \nTitle: %s \nDescription: %s \nPriority: %d\n",
                        task.getName(), task.getDescription(), task.getPriority());
        }
    }
}
