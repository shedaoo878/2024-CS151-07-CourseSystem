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


    public Department(String depName, ArrayList<Course> coursesInDep, ArrayList<Student> studentsInDep, ArrayList<Professor> profsInDep) {
        depName =  this.depName;
        coursesInDep =  this.coursesInDep;
        studentsInDep =  this.studentsInDep;
        profsInDep =  this.profsInDep;
    }

    public void addCourse(Course c){
        c.setDepartment(this);
        System.out.println(c.getTitle() + "now belongs to the " + this.toString() + "department." );
    }
    public void addStudent(Student s){
        s.setDepartment(this);
    }
    public void addProf(Professor p){
        
    }
    

    @Override
    public String toString(){
        return this.depName;
    }

    
}