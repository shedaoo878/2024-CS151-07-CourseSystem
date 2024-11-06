import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String depName;
    private final List<Course> coursesInDep;
    private final List<Student> studentsInDep;
    private final List<Professor> profsInDep;
    private final Campus campus;

    public Department(String depName, Campus campus, List<Course> courses, List<Student> students, List<Professor> professors) {
        this.depName = depName;
        this.campus = campus;
        this.coursesInDep = new ArrayList<>(courses != null ? courses : new ArrayList<>());
        this.studentsInDep = new ArrayList<>(students != null ? students : new ArrayList<>());
        this.profsInDep = new ArrayList<>(professors != null ? professors : new ArrayList<>());
        campus.addDepartment(this);
    }

    public Department(String depName, Campus campus) {
        this(depName, campus, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public void addCourse(Course course) {
        if (course != null && coursesInDep.add(course)) {
            System.out.println("Course " + course.getTitle() + " added to department " + depName);
        } else {
            printErrorMessage("Course", course != null ? course.getTitle() : "Unknown", "already in department or invalid");
        }
    }

    public void removeCourse(Course course) {
        coursesInDep.remove(course);
    }

    public void addStudent(Student student) {
        if (student != null && studentsInDep.add(student)) {
            student.setDepartment(this);
            System.out.println("Student " + student.getName() + " added to department " + depName);
        } else {
            printErrorMessage("Student", student != null ? student.getName() : "Unknown", "already in department or invalid");
        }
    }

    public void addProf(Professor professor) {
        if (professor != null && profsInDep.add(professor)) {
            professor.setDepartment(this);
            System.out.println("Professor " + professor.getName() + " added to department " + depName);
        } else {
            printErrorMessage("Professor", professor != null ? professor.getName() : "Unknown", "already in department or invalid");
        }
    }

    private void printErrorMessage(String entityType, String entityName, String message) {
        System.out.println("Error: " + entityType + " " + entityName + " - " + message);
    }

    public String getName() {
        return depName;
    }

    public final List<Course> getCoursesInDep() {
        return new ArrayList<>(coursesInDep);
    }

    public final List<Student> getStudentsInDep() {
        return new ArrayList<>(studentsInDep);
    }

    public final List<Professor> getProfsInDep() {
        return new ArrayList<>(profsInDep);
    }

    public Campus getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return "Department: " + depName + " (Courses: " + coursesInDep.size() + ", Students: " + studentsInDep.size() + ", Professors: " + profsInDep.size() + ")";
    }

    public void changePersonDepartment(int id) {
        Person person = campus.getPerson(id);
        if (person == null) {
            System.out.println("Student/Professor with ID " + id + " not found.");
        } else if (studentsInDep.contains(person) || profsInDep.contains(person)) {
            System.out.println("This Person is already in Department " + depName);
        } else {
            person.setDepartment(this);
            System.out.println(person.getName() + " is now part of Department " + depName);
        }
    }

    public void changeCourseDepartment(int id) {
        Course course = campus.findCourseById(id);
        if (course == null) {
            System.out.println("Course with ID " + id + " not found.");
        } else if (coursesInDep.contains(course)) {
            System.out.println("This course is already in Department " + depName);
        } else {
            course.setDepartment(course.getDepartment(), this);
        }
    }
}
