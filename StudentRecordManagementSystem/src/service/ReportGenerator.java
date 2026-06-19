package service;

import model.Student;
import java.util.List;

public class ReportGenerator {

    public static void generate(
            List<Student> students) {

        if (students.isEmpty()) {

            System.out.println(
                    "No student records found.");
            return;
        }

        double highest =
                students.get(0).getGpa();

        double lowest =
                students.get(0).getGpa();

        double total = 0;

        for (Student s : students) {

            double gpa = s.getGpa();

            if (gpa > highest)
                highest = gpa;

            if (gpa < lowest)
                lowest = gpa;

            total += gpa;
        }

        System.out.println("\n===== REPORT =====");

        System.out.println(
                "Total Students: "
                        + students.size());

        System.out.println(
                "Highest GPA: "
                        + highest);

        System.out.println(
                "Lowest GPA: "
                        + lowest);

        System.out.println(
                "Average GPA: "
                        + (total / students.size()));
    }
}