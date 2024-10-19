import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//junit4
public class DepartmentTest {
    private Campus campus;
    private Department csDepartment;
    private Course course1;
    private Course course2;
    private Student student1;
    private Student student2;
    private Professor professor1;

    @Before
    public void setUp() {
        campus = new Campus("Main Campus");
        
        csDepartment = new Department("Computer Science", campus);
        
        course1 = new Course(professor1, 0, csDepartment, 0, "Data Structures", false, null, null);
        course2 = new Course(professor1, 0, csDepartment, 0, "Algorithms", false, null, null);
        student1 = new Student("Emily", 1, csDepartment, 0, null, campus);
        student2 = new Student("Tyler", 2, csDepartment, 0, null, campus);
        professor1 = new Professor("Mr. Zhong", 0, "Computer Science", csDepartment);
    }

    @Test
    public void testAddCourse() {
        csDepartment.addCourse(course1);
        assertTrue(csDepartment.getCoursesInDep().contains(course1));
    }

    @Test
    public void testAddAlreadyExistingCourse() {
        csDepartment.addCourse(course1);
        csDepartment.addCourse(course1); 
        assertEquals(1, csDepartment.getCoursesInDep().size()); 
    }

    @Test
    public void testAddStudent() {
        csDepartment.addStudent(student1);
        assertTrue(csDepartment.getStudentsInDep().contains(student1));
    }

    @Test
    public void testAddAlreadyExistingStudent() {
        csDepartment.addStudent(student1);
        csDepartment.addStudent(student1); 
        assertEquals(1, csDepartment.getStudentsInDep().size()); 
    }

    @Test
    public void testAddProfessor() {
        csDepartment.addProf(professor1);
        assertTrue(csDepartment.getProfsInDep().contains(professor1));
    }

    @Test
    public void testAddAlreadyExistingProfessor() {
        csDepartment.addProf(professor1);
        csDepartment.addProf(professor1); 
        assertEquals(1, csDepartment.getProfsInDep().size()); 
    }

    @Test
    public void testApproveCourse() {
        csDepartment.approveCourse(course1);
        assertTrue(csDepartment.getCoursesInDep().contains(course1));
    }

    @Test
    public void testRemoveStudent() {
        csDepartment.addStudent(student1);
        csDepartment.removeStudent(student1);
        assertFalse(csDepartment.getStudentsInDep().contains(student1));
    }

    @Test
    public void testRemoveNonExistentStudent() {
        csDepartment.removeStudent(student1); 
        assertFalse(csDepartment.getStudentsInDep().contains(student1)); 
    }



}