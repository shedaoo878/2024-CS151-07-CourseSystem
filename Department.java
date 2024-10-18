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
        campus.addDepartment(this);
    }

    public void addCourse(Course c) {
        if (!coursesInDep.contains(c)) {
            c.setDepartment(this);
            coursesInDep.add(c);
            System.out.println("Course " + c.getTitle() + " added to department " + depName);
        } else {
            System.out.println("Course " + c.getTitle() + " is already in the department.");
        }
    }

    public void addStudent(Student s) {
        if (!studentsInDep.contains(s)) {
            s.setDepartment(this);
            studentsInDep.add(s);
            System.out.println("Student " + s.getName() + " added to department " + depName);
        } else {
            System.out.println("Student " + s.getName() + " is already in the department.");
        }
    }

    public void addProf(Professor p) {
        if (!profsInDep.contains(p)) {
            p.setDepartment(this);
            profsInDep.add(p);
            System.out.println("Professor " + p.getName() + " added to department " + depName);
        } else {
            System.out.println("Professor " + p.getName() + " is already in the department.");
        }
    }

    public String getName() {
        return this.depName;
    }

    public ArrayList<Course> getCoursesInDep() {
        return new ArrayList<>(coursesInDep);
    }

    public ArrayList<Student> getStudentsInDep() {
        return new ArrayList<>(studentsInDep);
    }

    public ArrayList<Professor> getProfsInDep() {
        return new ArrayList<>(profsInDep);
    }

    @Override
    public void approveCourse(Course course) {
        addCourse(course);
        System.out.println("Course " + course.getTitle() + " has been approved and added to the department " + depName);
    }

    @Override
    public void removeStudent(Student student) {
        if (studentsInDep.remove(student)) {
            System.out.println("Student " + student.getName() + " has been removed from the department " + depName);
        } else {
            System.out.println("Student " + student.getName() + " not found in the department " + depName);
        }
    }

    @Override
    public void viewDepartmentInfo() {
        System.out.println("Department Name: " + depName);
        System.out.println("Courses Offered: ");
        for (Course course : coursesInDep) {
            System.out.println(" - " + course.getTitle());
        }
        System.out.println("Students Enrolled: " + studentsInDep.size());
        System.out.println("Professors in Department: " + profsInDep.size());
    }

    public Campus getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return "Department: " + depName + " (Courses: " + coursesInDep.size() + 
               ", Students: " + studentsInDep.size() + ", Professors: " + profsInDep.size() + ")";
    }
}
