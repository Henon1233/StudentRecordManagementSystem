package main;

import model.Student;
import service.*;
import util.FileUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import service.StudentTextFileManager;
import service.StudentBinaryFileManager;

public class Main {

    private static List<Student> students = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        FileUtility.initializeFiles();

        try {
            students = StudentObjectFileManager.load();
        } catch (Exception e) {
            students = new ArrayList<>();
        }

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" STUDENT RECORD MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Generate Report");
            System.out.println("7. Create Backup");
            System.out.println("8. Display File Information");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    searchStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    displayStudents();
                    break;

                case 6:
                    ReportGenerator.generate(students);
                    break;

                case 7:
                    BackupManager.createBackup();
                    break;

                case 8:
                    displayFileInfo();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }

    private static void addStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = input.nextInt();
            input.nextLine();

            for (Student s : students) {
                if (s.getStudentId() == id) {
                    System.out.println("Student ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Department: ");
            String department = input.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = input.nextDouble();

            Student student =
                    new Student(id, name, department, gpa);

            students.add(student);

           

            System.out.println("Student added successfully.");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            input.nextLine();
        }
    }

    private static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        for (Student s : students) {

            if (s.getStudentId() == id) {

                System.out.println("\nStudent Found");
                System.out.println(s);

                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = input.nextInt();
        input.nextLine();

        for (Student s : students) {

            if (s.getStudentId() == id) {
                System.out.print("New Name: ");
                s.setName(input.nextLine());

                System.out.print("New Department: ");
                s.setDepartment(input.nextLine());

                System.out.print("New GPA: ");
                s.setGpa(input.nextDouble());

                saveAllFiles();

                System.out.println("Student updated successfully.");

                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = input.nextInt();

        Student target = null;

        for (Student s : students) {

            if (s.getStudentId() == id) {
                target = s;
                break;
            }
        }

        if (target != null) {

            students.remove(target);

            saveAllFiles();

            System.out.println("Student deleted successfully.");

        } else {

            System.out.println("Student not found.");
        }
    }

    private static void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No students available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void displayFileInfo() {

        System.out.println("\nTEXT FILE");
        FileUtility.displayFileInfo("data/students.txt");

        System.out.println("\nBINARY FILE");
        FileUtility.displayFileInfo("data/students.dat");

        System.out.println("\nOBJECT FILE");
        FileUtility.displayFileInfo("data/students.obj");
    }

    private static void saveAllFiles() {

        try {

            StudentTextFileManager.save(students);

            StudentBinaryFileManager.save(students);

            StudentObjectFileManager.save(students);

        } catch (Exception e) {

            System.out.println(
                    "Save Error: " + e.getMessage());
        }
    }
}
