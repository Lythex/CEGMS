import java.util.HashMap;

public class Student {
    // Private instance variables for student details
    private String name;
    private String ID;
    private HashMap<Course, String> enrolledCourses; // A map of Course objects and corresponding grades

    // Constructor
    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.enrolledCourses = new HashMap<>();
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.put(course, null); // Adding course with no grade initially
    }

    // Method to get enrolled courses
    public HashMap<Course, String> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to assign grade
    public void assignGrade(Course course, String grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade); // Updating the grade for the course
        }
    }
}
