import java.util.ArrayList;

public class Course implements Registerable{

    private String professor;
    private int section;
    private ArrayList<String> allowedMajors;
    private int credits;
    private String department;
    private int maxAllowed;
    private String classroom;
    private String title;
    private ArrayList<Student> enrolledStudents;
    

    public Course(String professor, int section, ArrayList<String> allowedMajors, int credits,
                  String department, int maxAllowed, String classroom, String title, boolean available, ArrayList<String> enrolledStudents, String timing) {
        this.professor = professor;
        this.section = section;
        this.allowedMajors = new ArrayList<String>();
        this.credits = credits;
        this.department = department;
        this.maxAllowed = maxAllowed;
        this.classroom = classroom;
        this.title = title;
        this.enrolledStudents = new ArrayList<Student>();
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

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
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
    public boolean isWaitlist() {
        return enrolledStudents.size() > maxAllowed;
    }
    
    
    public String listStudents() {
        if(enrolledStudents.isEmpty()) {
            return "No students are in this class.";
        }
        else {
            return String.join(" ,", enrolledStudents);
        }
    }


    @Override
    public void register(Student student) {
        if (student != null && !enrolledStudents.contains(student) && enrolledStudents.size() < maxAllowed && allowedMajors.contains(student.getMajor())) {
            enrolledStudents.add(student);  
            student.registerClass(this);
        } else if (enrolledStudents.contains(student)) {
            System.out.println(student.getName() + " is already registered for " + this.getTitle());
        } else if (enrolledStudents.size() >= maxAllowed) {
            System.out.println("Course is full. Registration failed for " + student.getName());
        } 
        else if(!allowedMajors.contains(student.getMajor())){
            System.out.println("This student is not allowed to take this course. Allowed majors are " + allowedMajors);
        }
        else {
            System.out.println("Invalid student. Registration failed.");
        }
    }

    @Override
    public void drop(Student student){
        if(enrolledStudents.contains(student)){
            enrolledStudents.remove(student);
            System.out.println("Student has been removed from course.");
        }
        else{
            System.out.println("This student cannot be dropped since student is not enrolled.");
        }
    }
}



