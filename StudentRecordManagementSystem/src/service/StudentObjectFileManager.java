package service;

import model.Student;

import java.io.*;
import java.util.*;

public class StudentObjectFileManager {

    public static void save(List<Student> students)
            throws IOException {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(
                                "data/students.obj"));

        out.writeObject(students);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public static List<Student> load() {

        List<Student> students =
                new ArrayList<>();

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(
                                    "data/students.obj"));

            students =
                    (List<Student>) in.readObject();

            in.close();

        } catch (Exception e) {

        }

        return students;
    }
}