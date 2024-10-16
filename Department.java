// - departmentName
// -courses[]
// - professors[]
// -students[]
// - addDepartment()
// - removeDepartment()
// - addProfessor()
// - addStudent()


import java.util.ArrayList;

public class Department{
    private String depName;
    private ArrayList<Course> coursesInDep;
    private ArrayList<Student> studentsInDep;
    private ArrayList<Professor> profsInDep;


    public Department(String depName) {
        this.depName = depName;
        this.coursesInDep = new ArrayList<Course>();
        this.studentsInDep = new ArrayList<Student>();
        this.profsInDep = new ArrayList<Professor>();
    }

    public void addCourse(Course c){
        c.setDepartment(this);
        coursesInDep.add(c);
    }
    public void addStudent(Student s){
        s.setDepartment(this);
        studentsInDep.add(s);
    }
    public void addProf(Professor p){
        p.setDepartment(this);
        profsInDep.add(p);
    }
    

    public String getName(){
        return this.depName;
    }

    
}