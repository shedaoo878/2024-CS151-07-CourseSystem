import java.util.Arrays;

public class Student implements Person {
    private String name;
    private int grade;
    private String major;
    private String minor;
    private double gpa;
    private String studentId;
    private Course[] currentEnrolledCourses;
    private String email;

    public Student(String name, int grade, String major, String minor, String studentId, String email, int enrollmentCap) {
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.minor = minor;
        this.studentId = studentId;
        this.email = email;
        this.gpa = 0.0;
        this.currentEnrolledCourses = new Course[enrollmentCap];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void register(Course course) {
        for (int i = 0; i < currentEnrolledCourses.length; i++) {
            if (currentEnrolledCourses[i] == null) {
                currentEnrolledCourses[i] = course;
                break;
            }
        }
    }

    public void drop(Course course) {
        for (int i = 0; i < currentEnrolledCourses.length; i++) {
            if (currentEnrolledCourses[i] == course) {
                currentEnrolledCourses[i] = null;
                break;
            }
        }
    }

    public Course[] viewCourses() {
        return Arrays.copyOf(currentEnrolledCourses, currentEnrolledCourses.length);
    }
}