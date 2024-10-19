import java.util.ArrayList;

public class Department {
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
            coursesInDep.add(c);
            System.out.println("Course " + c.getTitle() + " added to department " + depName);
        } else {
            System.out.println("Course " + c.getTitle() + " is already in the department.");
        }
    }

    public void removeCourse(Course c) {
        coursesInDep.remove(c);
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


    public Campus getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return "Department: " + depName + " (Courses: " + coursesInDep.size() + 
               ", Students: " + studentsInDep.size() + ", Professors: " + profsInDep.size() + ")";
    }

    public void changePersonDepartment(int id){
        Person person = campus.getPerson(id);
        if(person != null){
            person.setDepartment(this);
            System.out.println(person.getName() + " is now part of Department " + depName);
        }else{
            System.out.println("Student/Professor withID " + id + " is not found.");
        }
    }

    public void changeCourseDepartment(int id){
        Course course = campus.findCourseById(id);
        if(this.coursesInDep.contains(course)){
            System.out.println("This course is already in Department " + depName);
        }
        else if(course != null){
            course.setDepartment(course.getDepartment(), this);
        }
        else{
            System.out.println("Course with ID " + id + " is not found.");
        }
    }
}
