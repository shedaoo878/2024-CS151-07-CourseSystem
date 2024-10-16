import java.util.ArrayList;

public class Course implements Registerable{

    private Professor professor;
    private ArrayList<String> allowedMajors;
    private int credits;
    private Department department;
    private int maxAllowed;
    private String classroom;
    private String title;
    private ArrayList<Student> enrolledStudents;
    private int currentNumStudents;
    

    public Course(Professor professor, int credits,
                  Department department, int maxAllowed, String title, boolean available, ArrayList<String> enrolledStudents) {
        this.professor = professor;
        this.allowedMajors = new ArrayList<String>();
        this.credits = credits;
        this.department = department;
        this.maxAllowed = maxAllowed;
        this.title = title;
        this.enrolledStudents = new ArrayList<Student>();
        this.currentNumStudents = 0;
    }

    // getter and setter methods
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
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

    public int getCurrentNumStudents(){
        return currentNumStudents;
    }

    @Override
    public void register(Student student) {
        if (student != null && !enrolledStudents.contains(student) && enrolledStudents.size() < maxAllowed && student.getDepartment() == this.department) {
            enrolledStudents.add(student);  
            currentNumStudents++;
            System.out.println(student.getName() + " is now registered for " + this.getTitle());
        } else if (enrolledStudents.contains(student)) {
            System.out.println(student.getName() + " is already registered for " + this.getTitle());
        } else if (enrolledStudents.size() >= maxAllowed) {
            System.out.println("Course is full. Registration failed for " + student.getName());
        } 
        else if(student.getDepartment() != this.department){
            System.out.println("This student is not allowed to take this course. Allowed department is " + department.getName());
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
    public void printCourseInfo(){
        System.out.println("Course: " + title);
        System.out.println("Professor: " + professor);
        System.out.println("Credits: " + credits);
        System.out.println("Allowed Department: " + department);
        System.out.println("Current capacity: " + maxAllowed);
        System.out.println("Classroom: " + classroom);
        System.out.println("Current capacity: " + currentNumStudents + "/" + maxAllowed);
        System.out.println();
    }
}



