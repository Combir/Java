package org.example;

import java.util.*;

public class StudentStatisticsSoftware {
    private List<Student> students;
    private TreeSet<Student> scholarshipSorted;
    private TreeSet<Student> gradeSorted;
    private TreeSet<Student> ageSorted;

    public StudentStatisticsSoftware() {
        students = new ArrayList<>();
        scholarshipSorted = new TreeSet<>(new ScholarshipComparator());
        gradeSorted = new TreeSet<>(new GradeComparator());
        ageSorted = new TreeSet<>(new AgeComparator());
    }

    public void addStudent(Student student) {
        students.add(student);
        scholarshipSorted.add(student);
        gradeSorted.add(student);
        ageSorted.add(student);
    }

    public void removeStudent(String firstName, String lastName) {
        students.removeIf(student -> student.firstName.equalsIgnoreCase(firstName) &&
                student.lastName.equalsIgnoreCase(lastName));
        scholarshipSorted.removeIf(student -> student.firstName.equalsIgnoreCase(firstName) &&
                student.lastName.equalsIgnoreCase(lastName));
        gradeSorted.removeIf(student -> student.firstName.equalsIgnoreCase(firstName) &&
                student.lastName.equalsIgnoreCase(lastName));
        ageSorted.removeIf(student -> student.firstName.equalsIgnoreCase(firstName) &&
                student.lastName.equalsIgnoreCase(lastName));
    }

    public void modifyStudentGrade(String firstName, String lastName, double newGrade) {
        for (Student student : students) {
            if (student.firstName.equalsIgnoreCase(firstName) && student.lastName.equalsIgnoreCase(lastName)) {
                scholarshipSorted.remove(student);
                gradeSorted.remove(student);
                student.setAverageGrade(newGrade);
                scholarshipSorted.add(student);
                gradeSorted.add(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void changeScholarship(String firstName, String lastName, double newScholarship) {
        for (Student student : students) {
            if (student.firstName.equalsIgnoreCase(firstName) && student.lastName.equalsIgnoreCase(lastName)) {
                scholarshipSorted.remove(student);
                gradeSorted.remove(student);
                student.setScholarship(newScholarship);
                scholarshipSorted.add(student);
                gradeSorted.add(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void addAttendanceRecord(String firstName, String lastName, boolean attended) {
        for (Student student : students) {
            if (student.firstName.equalsIgnoreCase(firstName) && student.lastName.equalsIgnoreCase(lastName)) {
                student.addAttendance(attended);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayStudentsSorted(Comparator<Student> comparator) {
        students.stream().sorted(comparator).forEach(System.out::println);
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Statistics Software Menu ---");
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Modify a Student's Grade");
            System.out.println("4. Change Scholarship Amount");
            System.out.println("5. Add Attendance/Non-Attendance Record");
            System.out.println("6. Display Students (Sorted)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter first name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter middle name: ");
                        String middleName = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter average grade: ");
                        double averageGrade = scanner.nextDouble();
                        System.out.print("Enter scholarship: ");
                        double scholarship = scanner.nextDouble();
                        System.out.print("Enter attended classes: ");
                        int attendedClasses = scanner.nextInt();
                        System.out.print("Enter missed classes: ");
                        int missedClasses = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter gender: ");
                        String gender = scanner.nextLine();
                        try {
                            addStudent(new Student(firstName, lastName, middleName, age, averageGrade, scholarship,
                                    attendedClasses, missedClasses, gender));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter first name of student to remove: ");
                        String removeFirstName = scanner.nextLine();
                        System.out.print("Enter last name of student to remove: ");
                        String removeLastName = scanner.nextLine();
                        removeStudent(removeFirstName, removeLastName);
                        break;
                    case 3:
                        System.out.print("Enter first name of student: ");
                        String modFirstName = scanner.nextLine();
                        System.out.print("Enter last name of student: ");
                        String modLastName = scanner.nextLine();
                        System.out.print("Enter new average grade: ");
                        double newGrade = scanner.nextDouble();
                        modifyStudentGrade(modFirstName, modLastName, newGrade);
                        break;
                    case 4:
                        System.out.print("Enter first name of student: ");
                        String schFirstName = scanner.nextLine();
                        System.out.print("Enter last name of student: ");
                        String schLastName = scanner.nextLine();
                        System.out.print("Enter new scholarship amount: ");
                        double newScholarship = scanner.nextDouble();
                        changeScholarship(schFirstName, schLastName, newScholarship);
                        break;
                    case 5:
                        System.out.print("Enter first name of student: ");
                        String attFirstName = scanner.nextLine();
                        System.out.print("Enter last name of student: ");
                        String attLastName = scanner.nextLine();
                        System.out.print("Did the student attend the class? (true/false): ");
                        boolean attended = scanner.nextBoolean();
                        addAttendanceRecord(attFirstName, attLastName, attended);
                        break;
                    case 6:
                        System.out.println("Sort by: 1. Average Grade 2. Scholarship 3. Age 4. Attendance Percentage");
                        int sortChoice = scanner.nextInt();
                        Comparator<Student> comparator = null;
                        switch (sortChoice) {
                            case 1:
                                comparator = new GradeComparator();
                                break;
                            case 2:
                                comparator = new ScholarshipComparator();
                                break;
                            case 3:
                                comparator = new AgeComparator();
                                break;
                            case 4:
                                comparator = new AttendanceComparator();
                                break;
                            default:
                                System.out.println("Invalid choice. Returning to menu.");
                                continue;
                        }
                        displayStudentsSorted(comparator);
                        break;
                    case 7:
                        System.out.println("Exiting the software. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        StudentStatisticsSoftware software = new StudentStatisticsSoftware();
        software.displayMenu();
    }
}
