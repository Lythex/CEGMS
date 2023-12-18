import java.util.ArrayList;
import java.util.HashMap;

public class CourseManagement {
    // Static variables to store courses and grades
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Student, HashMap<Course, String>> courseGrades = new HashMap<>();

    static {
        initializeSampleData();
    }

    private static void initializeSampleData() {
        // Adding sample students
        students.add(new Student("Alice Johnson", "S1001"));
        students.add(new Student("Bob Smith", "S1002"));
        students.add(new Student("Charlie Brown", "S1003"));
        students.add(new Student("Diana Prince", "S1004"));
        students.add(new Student("Alphonse Elric", "S1005"));

        // Adding sample courses
        courses.add(new Course("C101", "Transmutation 101", 30));
        courses.add(new Course("C102", "Elixir Crafting", 30));
        courses.add(new Course("C103", "Elemental Fusion", 30));
        courses.add(new Course("C104", "Artisan Alchemy: Bringing Art to Life", 30));
        courses.add(new Course("C105", "Intro to Alchemy", 30));
    }



    // Method to find a student by ID
    public static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null; // Return null if no student found with the given ID
    }

    // Method to find a course by code
    public static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null; // Return null if no course found with the given code
    }

    // Additional methods for managing course grades
    public static void enrollStudent(Student student, Course course) {
        if (!courseGrades.containsKey(student)) {
            courseGrades.put(student, new HashMap<>());
        }
        courseGrades.get(student).put(course, null); // Initially no grade
        student.enrollInCourse(course); // Assuming this method exists in Student class

        if (Course.getTotalEnrolledStudents() < course.getMaxCapacity()) {
            student.enrollInCourse(course);
            Course.incrementEnrolledStudents();
            if (!courseGrades.containsKey(student)) {
                courseGrades.put(student, new HashMap<>());
            }
            courseGrades.get(student).put(course, null);
        } else {
            System.out.println("Course capacity reached.");
        }
    }

    public static void assignGrade(Student student, Course course, String grade) {

        if (courseGrades.containsKey(student) && courseGrades.get(student).containsKey(course)) {
            courseGrades.get(student).put(course, grade);
            student.assignGrade(course, grade);
        }
    }

    public static String calculateOverallGrade(Student student) {
        HashMap<Course, String> grades = courseGrades.get(student);

        if (grades == null || grades.isEmpty()) {
            return "No grades available";
        }

        double sum = 0;
        int count = 0;
        for (String grade : grades.values()) {
            if (grade != null && !grade.isEmpty()) {
                sum += convertGradeToPoints(grade);
                count++;
            }
        }

        if (count == 0) {
            return "No grades to calculate";
        }

        double average = sum / count;
        return convertPointsToGrade(average);
    }

    // Helper method to convert letter grades to a numerical scale (e.g., A=4, B=3, etc.)
    private static double convertGradeToPoints(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0; // Default to 0 for unrecognized grades
        }
    }

    // Helper method to convert the numerical average back to a letter grade
    private static String convertPointsToGrade(double points) {
        if (points >= 3.5) return "A";
        if (points >= 2.5) return "B";
        if (points >= 1.5) return "C";
        if (points >= 0.5) return "D";
        return "F";}

    // Rest of the methods...

    // Method to add a new course
    public static void addCourse(Course course) {
        courses.add(course);
    }

    // Method to enroll a student in a course
//    public static void enrollStudent(Student student, Course course) {
//        if (course.getTotalEnrolledStudents() < course.getMaxCapacity()) {
//            student.enrollInCourse(course);
//            Course.incrementEnrolledStudents();
//            if (!courseGrades.containsKey(student)) {
//                courseGrades.put(student, new HashMap<>());
//            }
//            courseGrades.get(student).put(course, null);
//        } else {
//            System.out.println("Course capacity reached.");
//        }
//    }

//    // Method to assign a grade
//    public static void assignGrade(Student student, Course course, String grade) {
//        if (courseGrades.containsKey(student) && courseGrades.get(student).containsKey(course)) {
//            courseGrades.get(student).put(course, grade);
//            student.assignGrade(course, grade);
//        }
//    }

//    // Method to calculate overall grade for a student
//    public static String calculateOverallGrade(Student student) {
//        HashMap<Course, String> grades = student.getEnrolledCourses();
//        // Calculate and return the overall grade based on the grades map
//        // This is left as an exercise - you could average the grades or use another method
//        return "Overall Grade Calculation Here";
//    }
//
//

// Method Graveyard:
// New methods for data retrieval
//    public static Student findStudentById(String id) {
//        // Logic to find and return a student by ID
//        // This could be a search in an ArrayList or HashMap
//    }
//
//    public static Course findCourseByCode(String code) {
//        // Logic to find and return a course by its code
//        // This could be a search in an ArrayList or HashMap
//    }
}
