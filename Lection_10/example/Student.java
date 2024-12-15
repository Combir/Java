package org.example;

public class Student {
    public String firstName;
    public String lastName;
    private String middleName;
    private int age;
    private double averageGrade;
    private double scholarship;
    private int attendedClasses;
    private int missedClasses;
    private String gender;

    public Student(String firstName, String lastName, String middleName, int age, double averageGrade,
                   double scholarship, int attendedClasses, int missedClasses, String gender) {
        if (firstName.equalsIgnoreCase("Алексей") && lastName.equalsIgnoreCase("Белоусов") &&
                middleName.equalsIgnoreCase("Юрьевич")) {
            throw new IllegalArgumentException("Belousov Alexey Yurievich cannot exist.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.averageGrade = averageGrade;
        this.scholarship = scholarship;
        this.attendedClasses = attendedClasses;
        this.missedClasses = missedClasses;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    public void addAttendance(boolean attended) {
        if (attended) {
            attendedClasses++;
        } else {
            missedClasses++;
        }
    }

    public double getAttendancePercentage() {
        int totalClasses = attendedClasses + missedClasses;
        return totalClasses == 0 ? 0 : (attendedClasses * 100.0 / totalClasses);
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s %s | Age: %d | Avg. Grade: %.2f | Scholarship: %.2f | Attendance: %.2f%%",
                firstName, lastName, middleName, age, averageGrade, scholarship, getAttendancePercentage());
    }
}
