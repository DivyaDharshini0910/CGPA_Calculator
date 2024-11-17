import java.util.Scanner;

class Student {
    String name;
    int rollNumber;

    public void inputDetails(Scanner scanner) {
        System.out.print("Enter student name: ");
        name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        rollNumber = Integer.parseInt(scanner.nextLine());
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class GradeCalculator extends Student {
    int numSubjects;
    double[] grades;
    double cgpa;

    public void inputGrades(Scanner scanner) {
        System.out.print("Enter the number of subjects: ");
        numSubjects = Integer.parseInt(scanner.nextLine());
        grades = new double[numSubjects];

        System.out.println("Enter the grades for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            grades[i] = Double.parseDouble(scanner.nextLine());
        }
    }

    public void calculateCGPA() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        cgpa = sum / numSubjects;
    }

    public void displayCGPA() {
        System.out.printf("CGPA: %.2f\n", cgpa);
    }
}

public class Main {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeCalculator student = new GradeCalculator();

        student.inputDetails(scanner);
        student.inputGrades(scanner);

        student.calculateCGPA();
        System.out.println("\n--- Student Details ---");
        student.displayDetails();
        student.displayCGPA();

        scanner.close();
    }
}