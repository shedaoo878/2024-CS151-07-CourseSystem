import java.util.ArrayList;

public class Course {

    private String professor;
    private int section;
    private ArrayList<String> allowedMajors;
    private int credits;
    private String department;
    private int maxAllowed;
    private String classroom;
    private String title;
    private boolean available;
    private ArrayList<String> enrolledStudents;
    private String timing;

    public Course(String professor, int section, ArrayList<String> allowedMajors, int credits,
                  String department, int maxAllowed, String classroom, String title, boolean available, ArrayList<String> enrolledStudents, String timing) {
        this.professor = professor;
        this.section = section;
        this.timing = timing;
        this.allowedMajors = new ArrayList<String>();
        this.credits = credits;
        this.department = department;
        this.maxAllowed = maxAllowed;
        this.classroom = classroom;
        this.title = title;
        this.available = available;
        this.enrolledStudents = new ArrayList<String>();
    }

    // getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public ArrayList<String> getAllowedMajors() {
        return allowedMajors;
    }

    public void setAllowedMajors(ArrayList<String> allowedMajors) {
        this.allowedMajors = allowedMajors;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(int maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //isAvailable()
    public boolean isAvailable() {
        return enrolledStudents.size() <= maxAllowed;
    }

    //isWaitlist()
    public boolean isWaitlist() {
        return enrolledStudents.size() > maxAllowed;
    }

    //addStudent()
    public boolean addStudent(String student, String major) {
        if(enrolledStudents.size() < maxAllowed && allowedMajors.contains(major)) {
            return true;
        }
        else {
            return false;
        }
    }
    //removeStudent()
    public boolean removeStudent(String student) {
        if(enrolledStudents.contains(student)) {
            enrolledStudents.remove(student);
            return true;
        }
        else {
            return false;
        }
    }

    //listStudents()
    public String listStudents() {
        if(enrolledStudents.isEmpty()) {
            return "No students are in this class.";
        }
        else {
            return String.join(" ,", enrolledStudents);
        }
    }
}
