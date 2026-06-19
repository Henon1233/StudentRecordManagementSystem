package service;

import model.Student;

import java.io.*;
import java.util.*;

public class StudentTextFileManager {

    private static final String FILE =
            "data/students.txt";

    public static void save(List<Student> students)
            throws IOException {

        PrintWriter writer =
                new PrintWriter(FILE);

        for (Student s : students) {

            writer.println(
                    s.getStudentId() + "," +
                    s.getName() + "," +
                    s.getDepartment() + "," +
                    s.getGpa()
            );
        }

        writer.close();
    }

    public static List<Student> load()
            throws IOException {

        List<Student> students =
                new ArrayList<>();

        Scanner scanner =
                new Scanner(new File(FILE));

        while (scanner.hasNextLine()) {

            String[] data =
                    scanner.nextLine().split(",");

            students.add(
                    new Student(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            Double.parseDouble(data[3])
                    )
            );
        }

        scanner.close();
        return students;
    }
}
