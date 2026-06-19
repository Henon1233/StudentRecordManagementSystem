package service;

import model.Student;

import java.io.*;
import java.util.*;

public class StudentBinaryFileManager {

    public static void save(List<Student> students)
            throws IOException {

        DataOutputStream dos =
                new DataOutputStream(
                        new FileOutputStream(
                                "data/students.dat"));

        dos.writeInt(students.size());

        for (Student s : students) {

            dos.writeInt(s.getStudentId());
            dos.writeUTF(s.getName());
            dos.writeUTF(s.getDepartment());
            dos.writeDouble(s.getGpa());
        }

        dos.close();
    }

    public static List<Student> load()
            throws IOException {

        List<Student> list =
                new ArrayList<>();

        File file =
                new File("data/students.dat");

        if (file.length() == 0)
            return list;

        DataInputStream dis =
                new DataInputStream(
                        new FileInputStream(file));

        int size = dis.readInt();

        for (int i = 0; i < size; i++) {

            list.add(
                    new Student(
                            dis.readInt(),
                            dis.readUTF(),
                            dis.readUTF(),
                            dis.readDouble()
                    )
            );
        }

        dis.close();
        return list;
    }
}