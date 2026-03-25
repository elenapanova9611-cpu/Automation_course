//Rework while example
package homework;

import java.util.Scanner;

public class Task2 {
    public  static void main(String[] args) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter something");
            userInput = scanner.nextLine();
        } while (!userInput.equals("Exit"));

        System.out.println("You've entered: " + userInput);
    }
}

