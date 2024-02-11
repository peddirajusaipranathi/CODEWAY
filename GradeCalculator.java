import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int totalMarks = 0;
        int[] marksArray = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marksArray[i] = scanner.nextInt();
            totalMarks += marksArray[i];
        }

        // Calculate total marks
        double averagePercentage = (double) totalMarks / numSubjects;

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
