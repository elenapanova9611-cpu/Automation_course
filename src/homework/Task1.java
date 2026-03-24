//Rework if else example
package homework;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int score;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter your score: ");
            score = scanner.nextInt();

            if (isInvalidScore(score)) {
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
            } else {
                System.out.println("Your grade is F!");
            }
        } while (isInvalidScore(score));
    }

    private static boolean isInvalidScore(int score) {
        return score < 0 || score > 100;
    }
}
