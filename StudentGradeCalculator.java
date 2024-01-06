import java.util.Scanner;
public class StudentGradeCalculator{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        int numSubjects = 0;
        while (numSubjects <= 0) {
            System.out.print("Enter number of subjects (positive integer): ");
            numSubjects = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        }

        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++){
            while (true) {
                System.out.printf("Enter marks for subject %d (0-100): ", i + 1);
                int mark = scanner.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                }
            }
            scanner.nextLine(); // Consume newline character
        }

        calculateGrade(studentName, marks);
    }

    public static void calculateGrade(String studentName, int[] marks){
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }

        float average = (float) total / marks.length;
        char grade = 'F';

        if (average >= 80) {
            grade = 'O';
        } else if (average >= 70) {
            grade = 'A';
        } else if (average >= 60) {
            grade = 'B';
        } else if (average >= 50) {
            grade = 'C';
        }

        System.out.println("\nStudent Name: " + studentName);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}
