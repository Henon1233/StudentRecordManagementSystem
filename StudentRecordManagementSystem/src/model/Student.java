package model;

import java.io.Serializable;

public class Student implements Serializable {

    private int studentId;
    private String name;
    private String department;
    private double gpa;

    public Student(int studentId, String name,
                   String department, double gpa) {

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return studentId + " | " +
                name + " | " +
                department + " | " +
                gpa;
    }
}