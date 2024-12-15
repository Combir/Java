package org.example;

import java.util.Comparator;

public class AttendanceComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage());
    }
}
