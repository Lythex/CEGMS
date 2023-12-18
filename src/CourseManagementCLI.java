import java.util.Scanner;

public class CourseManagementCLI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrade();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nCourse Enrollment and Grade Management System");
        System.out.println("1. Add New Course");
        System.out.println("2. Enroll Student in Course");
        System.out.println("3. Assign Grade to Student");
        System.out.println("4. Calculate Overall Grade for Student");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addCourse() {
        System.out.print("Enter Course Code: ");
        String code = scanner.next();
        System.out.print("Enter Course Name: ");
        scanner.nextLine();  // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Maximum Capacity: ");
        int capacity = scanner.nextInt();

        Course course = new Course(code, name, capacity);
        CourseManagement.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.next();

        Student student = CourseManagement.findStudentById(studentId);
        Course course = CourseManagement.findCourseByCode(courseCode);

        if (student != null && course != null) {
            CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Error: Student or Course not found.");
        }
    }

    private static void assignGrade() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.next();
        System.out.print("Enter Grade: ");
        String grade = scanner.next();

        Student student = CourseManagement.findStudentById(studentId);
        Course course = CourseManagement.findCourseByCode(courseCode);

        if (student != null && course != null) {
            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Error: Student or Course not found.");
        }
    }

    private static void calculateOverallGrade() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();

        Student student = CourseManagement.findStudentById(studentId);
        if (student != null) {
            String overallGrade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall Grade for " + studentId + ": " + overallGrade);
        } else {
            System.out.println("Student not found.");
        }
    }
}
