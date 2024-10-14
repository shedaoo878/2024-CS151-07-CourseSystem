import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Student implements Person {
    private String name;
    private int grade;
    private String major;
    private int studentId;
    private ArrayList<Course> currentEnrolledCourses;
    private String email;
    private int courseCredits;
    private Department dep;
    private List<Club> clubs;
    private Campus campus;
    private Department department;
    final int MAXCREDITS = 15;
    final int MINCREDITS = 12;


    
    public Student(String name, int grade, String major, int studentId, String email) {
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.studentId = studentId;
        this.email = email;
        this.currentEnrolledCourses = new ArrayList<Course>();
        this.courseCredits = 0;
        this.clubs = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printEmail() {
        System.out.println("Email: " + email);
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Department getDepartment(){
        return dep;
    }
    public void setDepartment(Department d){
        dep = d;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public void getCurrentCredits(){
        System.out.println("Current course credits: " + courseCredits);
    }


    public int getStudentId() {
        return studentId;
    }


    public void registerClass(Registerable course) {
        if((((Course)course).getCredits() + courseCredits) < MAXCREDITS){
            ((Course)course).register(this);
        }
        else{
            System.out.println("You cannot take above 17 credits. Please take next semester or find another course.");
            getCurrentCredits();
        }
    }
    public void dropClass(Course course){
        if((((Course)course).getCredits() - courseCredits) > MINCREDITS){
            ((Course)course).drop(this);
        }
        else{
            ((Course)course).drop(this);
            System.out.println("Course has been dropped, but you must add another class to ensure you are above 12 credits.");
            getCurrentCredits();
        }
    }

    public ArrayList<Course> getCurrentEnrolledCourses() {
        return new ArrayList<>(currentEnrolledCourses);
    }
    public void printSchedule(){
        System.out.println("Current Enrolled Courses:");
        if (currentEnrolledCourses.isEmpty()) {
            System.out.println("  No courses enrolled");
        } else {
            for (Course course : currentEnrolledCourses) {
                System.out.println("  - " + course.getTitle() + "- Professor: " + course.getProfessor() + " ----");
            }
        }
    }
    
    public void displayInfo() {
        System.out.println("Student Information for " + name + " ------------");
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade: " + grade);
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Department: " + (dep != null ? dep.toString() : "Not assigned"));
        //System.out.println("Campus: " + (campus != null ? campus.getName() : "Not assigned"));
        
        System.out.println("Current Enrolled Courses:");
        if (currentEnrolledCourses.isEmpty()) {
            System.out.println("  No courses enrolled");
        } else {
            for (Course course : currentEnrolledCourses) {
                System.out.println("  - " + course.getTitle());
            }
        }
        
        System.out.println("Clubs:");
        // if (clubs.isEmpty()) {
        //     System.out.println("  No clubs joined");
        // } else {
        //     for (Club club : clubs) {
        //         System.out.println("  - " + club.getTitle());
        //     }
        // }
        System.out.println("--------------------------------------------");
    }

    public Campus getCampus() {
        return campus;
    }

    public List<Club> getClubs() {
        return new ArrayList<>(clubs);
    }
}
