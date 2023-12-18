public class Course {
    // Private instance variables
    private String courseCode;
    private String name;
    private int maxCapacity;
    // Static variable to track total enrolled students across all courses
    private static int totalEnrolledStudents = 0;

    // Constructor
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    // Getter methods
    public String getCourseCode() {

        return courseCode;
    }

    public String getName() {

        return name;
    }

    public int getMaxCapacity() {

        return maxCapacity;
    }

    // Static method to get total enrolled students
    public static int getTotalEnrolledStudents() {

        return totalEnrolledStudents;
    }

    // Method to increase total enrolled students count
    public static void incrementEnrolledStudents() {

        totalEnrolledStudents++;
    }
}
