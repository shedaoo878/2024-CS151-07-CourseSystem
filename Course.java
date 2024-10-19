import java.util.ArrayList;
import java.util.HashMap;

public class Course implements Registerable{

    private Professor professor;
    private ArrayList<String> allowedMajors;
    private int credits;
    private Department department;
    private int maxAllowed;
    private String title;
    private int id;
    private ArrayList<Student> enrolledStudents;
    private int currentNumStudents;
    private HashMap<Student, Character> gradesList;
    private ArrayList<Student> admins;
    private Campus campus;

    public Course(Professor professor, Department department, String title, int id) {
        this.professor = professor;
        this.department = department;
        this.title = title;
        this.id = id;
    }

    public Course(Professor professor, int credits,
                  Department department, int maxAllowed, String title, ArrayList<String> enrolledStudents, int id, Campus campus) {
        this.professor = professor;
        this.allowedMajors = new ArrayList<String>();
        this.credits = credits;
        this.department = department;
        department.addCourse(this);

        this.maxAllowed = maxAllowed;
        this.title = title;
        this.id = id;
        this.enrolledStudents = new ArrayList<Student>();
        this.currentNumStudents = 0;
        this.gradesList = new HashMap<Student, Character>();
        for(Student s : this.enrolledStudents){
            gradesList.put(s, 'Z');
        }
        this.campus = campus;
        campus.addCourse(this);

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
    public void setDepartment(Department oldDep, Department newDepartment) {

        oldDep.removeCourse(this);
        newDepartment.addCourse(this);
        this.department = newDepartment;
        System.out.println("Course " + title + " is now part of Department " + department.getName());
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }
    public void setMaxAllowed(int maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public boolean isWaitlist() {
        return enrolledStudents.size() > maxAllowed;
    }
    
    
    public String listStudents() {
        if(enrolledStudents.isEmpty()) {
            return "No students are in this class.";
        }
        else {
            //return String.join(" ,", enrolledStudents);
            ArrayList<String> studentName = new ArrayList<>();
            for (Student s : enrolledStudents) {
                studentName.add(s.getName());
            }
            return String.join(", ", studentName);
        }
    }

    public int getCurrentNumStudents(){
        return currentNumStudents;
    }
    public int getId(){
        return id;
    }
    public Student getStudent(int studentID){
        for(Student s : enrolledStudents){
            if(s.getStudentId() == studentID){
                return s;
            }
        }
        return null;
    }
    
    public int getEnrolledStudents() {
        return enrolledStudents.size();
    }
    public ArrayList<Student> getEnrolledStudentsList(){
        return enrolledStudents;
    }

    @Override
    public void register(Student student) {
        if (student.getDepartment() != this.department) {
            System.out.println("This student is not allowed to take this course. Allowed department is " + department.getName());
            return;
        }
        if (student != null && !enrolledStudents.contains(student) && enrolledStudents.size() < maxAllowed && student.getDepartment() == this.department) {
            enrolledStudents.add(student);  
            student.addRegisteredCourse(this);
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
        System.out.println("Professor: " + professor.getName());
        System.out.println("Credits: " + credits);
        System.out.println("Allowed Department: " + department.getName());
        System.out.println("Current capacity: " + maxAllowed);
        System.out.println("Current capacity: " + currentNumStudents + "/" + maxAllowed);
        System.out.println();
    }

    public void setGrade(Admin admin,Student student, char grade){
        gradesList.put(student, grade);
        System.out.println("Grade has been set to " + grade + "by an Admin");
    }
    public void addAdmin(Student student){
        admins.add(student);
    }
    public ArrayList<Student> getAdmins(){
        return admins;
    }
    public char getGrade(Student student){
        return gradesList.get(student);
    }
}
