import java.util.ArrayList;

public class Department implements Admin {
    private String depName;
    private ArrayList<Course> coursesInDep;
    private ArrayList<Student> studentsInDep;
    private ArrayList<Professor> profsInDep;
    private Campus campus;

    public Department(String depName, Campus campus) {
        this.depName = depName;
        this.coursesInDep = new ArrayList<>();
        this.studentsInDep = new ArrayList<>();
        this.profsInDep = new ArrayList<>();
        this.campus = campus;
    }

    public void addCourse(Course c) {
        c.setDepartment(this);
        coursesInDep.add(c);
    }

    public void addStudent(Student s) {
        s.setDepartment(this);
        studentsInDep.add(s);
    }

    public void addProf(Professor p) {
        p.setDepartment(this);
        profsInDep.add(p);
    }

    public String getName() {
        return this.depName;
    }

    public ArrayList<Course> getCoursesInDep() {
        return coursesInDep;
    }

    public ArrayList<Student> getStudentsInDep() {
        return studentsInDep;
    }

    public ArrayList<Professor> getProfsInDep() {
        return profsInDep;
    }

    @Override
    public void approveCourse(Course course) {
        addCourse(course);
        System.out.println("Course " + course.getTitle() + " has been approved and added to the department.");
    }

    @Override
    public void removeStudent(Student student) {
        if (studentsInDep.remove(student)) {
            System.out.println("Student " + student.getName() + " has been removed from the department.");
        } else {
            System.out.println("Student " + student.getName() + " not found in the department.");
        }
    }

    @Override
    public void viewDepartmentDetails() {
        System.out.println("Department Name: " + depName);
        System.out.println("Courses Offered: ");
        for (Course course : coursesInDep) {
            System.out.println(" - " + course.getTitle());
        }
        System.out.println("Students Enrolled: ");
        for (Student student : studentsInDep) {
            System.out.println(" - " + student.getName());
        }
        System.out.println("Professors in Department: ");
        for (Professor prof : profsInDep) {
            System.out.println(" - " + prof.getName());
        }
    }
    
}
