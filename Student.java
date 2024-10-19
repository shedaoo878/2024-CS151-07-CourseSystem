
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person implements Admin {
    private String name;
    private int grade;
    private int studentId;
    private ArrayList<Course> currentEnrolledCourses;
    private String email;
    private int courseCredits;
    private Department dep;
    private List<Club> clubs;
    private Campus campus;
    final int MAXCREDITS = 15;
    final int MINCREDITS = 12;


    public Student(String name, int grade, Department department, int studentId, String email, Campus campus) {
        super(name, studentId, email, department, campus);
        this.name = name;
        this.grade = grade;
        this.studentId = studentId;
        this.email = email;
        this.currentEnrolledCourses = new ArrayList<Course>();
        this.courseCredits = 0;
        this.clubs = new ArrayList<>();
        this.dep = department;
        department.addStudent(this);
        this.campus = campus;
        campus.addPerson(this);
    }
    public Student(String name, int grade, int studentId, String email, Campus campus) {
        super(name, studentId, email, null, campus);
        this.grade = grade;
        this.studentId = studentId;
        this.email = email;
        this.currentEnrolledCourses = new ArrayList<Course>();
        this.courseCredits = 0;
        this.clubs = new ArrayList<>();
        this.dep = null;
        this.campus = campus;
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

    

    public Department getDepartment(){
        return dep;
    }
    public void setDepartment(Department d){
        dep = d;
    }

    public void getCurrentCredits(){
        System.out.println("Current course credits: " + courseCredits);
    }


    public int getStudentId() {
        return studentId;
    }

    public void registerClass(Registerable course) {
        if (((Course) course).getDepartment() != this.getDepartment()) {
            System.out.println("This student is not allowed to take this course. Allowed department is " + ((Course) course).getDepartment().getName());
            return;
        }
        if((((Course)course).getCredits() + courseCredits) < MAXCREDITS){
            ((Course)course).register(this);
            courseCredits += ((Course)course).getCredits();
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
    public void addRegisteredCourse(Course course) {
        currentEnrolledCourses.add(course);
    }

    //add an enroll course method to make sure eligible course has is added to currentEnrolledCourses
    public void addCourse(Course course) {
        if (!currentEnrolledCourses.contains(course)) {
            currentEnrolledCourses.add(course);
        } else {
            System.out.println("Student is already enrolled in " + course.getTitle());
        }
    }

    public void removeCourse(Course course) {
        if (currentEnrolledCourses.contains(course)) {
            currentEnrolledCourses.remove(course);
        } else {
            System.out.println("Student is not enrolled in " + course.getTitle());
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
                System.out.println("  - " + course.getTitle() + "- Professor: " + course.getProfessor().getName() + " ----");
            }
        }
        System.out.println();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Student Information for " + name + " ------------");
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade: " + grade);
        System.out.println("Email: " + email);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Department: " + (dep != null ? dep.getName() : "Not assigned"));
        System.out.println("Campus: " + (campus != null ? campus.getCampusName() : "Not assigned"));
        System.out.println();
        System.out.println("Current Enrolled Courses:");
        if (currentEnrolledCourses.isEmpty()) {
            System.out.println("  No courses enrolled");
        } else {
            for (Course course : currentEnrolledCourses) {
                System.out.println("  - " + course.getTitle());
            }
        }
        System.out.println();
        System.out.println("Clubs:");
        if (clubs.isEmpty()) {
            System.out.println("  No clubs joined");
        } else {
            for (Club club : clubs) {
                System.out.println(" -- " + club.getClubName());
            }
        }
        System.out.println();
    }

    public Campus getCampus() {
        return campus;
    }

    public void addToClubs(Club club) {
        clubs.add(club);
    }

    public void addClasses(Scanner scanner, List<Course> availableCourses) {
        System.out.println("Available Courses:");
        for (int i = 0; i < availableCourses.size(); i++) {
            System.out.println((i + 1) + ") " + availableCourses.get(i).getTitle());
        }
        
        System.out.print("Enter the number of a course to view info and register (enter 0 to exit to main menu): ");


        int choice = scanner.nextInt();
        
        while (choice != 0) {
            if (choice > 0 && choice <= availableCourses.size()) {
                Course selectedCourse = availableCourses.get(choice - 1);
                System.out.println();
                selectedCourse.printCourseInfo();
                System.out.print("Would you like to register for this course? (y to register / n to not register and return back to course menu): ");    

                String willRegister = scanner.next();
                if(willRegister.equalsIgnoreCase("y")){
                    this.registerClass(selectedCourse);
                    choice = 0;
                }
                else if(willRegister.equalsIgnoreCase("n")){
                    choice = 0;
                    addClasses(scanner, availableCourses);
                }
                else{
                    System.out.println("Invalid input.");
                }

                
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            return;
            
            
        }
    }
    public void joinClubs(Scanner s, List<Club> availableClubs) {
        System.out.println();
        System.out.println("Available Clubs:");
        for (int i = 0; i < availableClubs.size(); i++) {
            System.out.println((i + 1) + ". " + availableClubs.get(i).getClubName());
        }

        System.out.print("Enter the number of a club to view info and register (enter 0 to exit to main menu): ");
        int choice = s.nextInt();

        if (choice == 0) {
            return;
        } else if (choice > 0 && choice <= availableClubs.size()) {
            Club selectedClub = availableClubs.get(choice - 1);
            selectedClub.printClubDetails();
            System.out.println();

            System.out.print("Do you want to join this club? (y to join / n to cancel and return back to club menu): ");
            String response = s.next();

            if (response.equals("y")) {
                selectedClub.register(this);
            } 
            else if (response.equals("n")) {
                joinClubs(s, availableClubs);
            }   
            else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
    public boolean isAdmin(Course course) {
        if(course.getAdmins().contains(this)){
            return true;
        }else{
            return false;
        }
    }

    

    @Override
    public void addGrade(Student student, Course course, char grade) {
        if(isAdmin(course)){    
            course.setGrade(this,student, grade);
        }else{
            System.out.println("You are not an Admin");
        }
    }

    @Override
    public void addAdmin(Student student, Course course) {
        System.out.println("Students are not authorized to add admins.");
    }
    public void printGrades(Course course){
        if(course.getGrade(this) == 'Z'){
            System.out.println("You have not been graded in this course yet.");
        }else{
            System.out.println("Grade in course " + course.getTitle() + "is: " + course.getGrade(this));
        }
    }
}

    
