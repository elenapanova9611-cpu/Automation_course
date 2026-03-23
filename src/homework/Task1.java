//Rework if else example
package homework;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        int score = -1;
        while (isValidScore(score)) {
            System.out.println("Please enter your score: ");
            score = new Scanner(System.in).nextInt();

            if (isValidScore(score)) {
                System.out.println("Your input is incorrect.");
                continue;
            }

            if (score >= 90) {
                System.out.println("Your grade is A!");
            } else if (score >= 80) {
                System.out.println("Your grade is B!");
            } else if (score >= 70) {
                System.out.println("Your grade is C!");
            } else if (score >= 60) {
                System.out.println("Your grade is D!");
            } else if (score >= 50) {
                System.out.println("Your grade is E!");
            } else if (score >= 0) {
                System.out.println("Your grade is F!");
            }
        }
    }

    private static boolean isValidScore(int score) {
        return score < 0 || score > 100;
    }
}
