package org.example;

import java.util.Comparator;

public class ScholarshipComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getScholarship(), s1.getScholarship());
    }
}
