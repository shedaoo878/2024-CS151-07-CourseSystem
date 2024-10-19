import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;


// junit4
public class CampusTest {
	private Campus campus;
	private Department csDepartment;
	private Club codingClub;
	private Professor trev;
	private Course course1;

	@Before
	public void setUp() {
		campus = new Campus("Main Campus");
		csDepartment = new Department("Computer Science", campus);
		codingClub = new Club("Coding Club", null, campus, 0);
		trev = new Professor("Mr. Zhong", 0, null, csDepartment);
		course1 = new Course(trev, 3, csDepartment, 30, "CS151", true, new ArrayList<>(), "Duncan Hall 412");
	}

	@Test
	public void testAddDepartment() {
		campus.addDepartment(csDepartment);
		assertTrue(campus.getDepartments().contains(csDepartment));
	}

	@Test
	public void testRemoveDepartment() {
		campus.addDepartment(csDepartment);
		campus.removeDepartment(csDepartment);
		assertFalse(campus.getDepartments().contains(csDepartment));
	}

	@Test
	public void testAddClub() {
		campus.addClub(codingClub);
		assertTrue(campus.getClubs().contains(codingClub));
	}

	@Test
	public void testRemoveClub() {
		campus.addClub(codingClub);
		campus.removeClub(codingClub);
		assertFalse(campus.getClubs().contains(codingClub));
	}

	@Test
	public void testAddCourse() {
		campus.addCourse(course1);
		assertTrue(campus.getCourses().contains(course1));
	}

	@Test
	public void testRemoveCourse() {
		campus.addCourse(course1);
		campus.removeCourse(course1);
		assertFalse(campus.getCourses().contains(course1));
	}

	@Test
	public void testGetStudentCount() {
		Student student1 = new Student("Emily", 1, csDepartment, 0, null, campus);
		Student student2 = new Student("Tyler", 1, csDepartment, 0, null, campus);

		course1.register(student1);
		course1.register(student2);
		
		campus.addCourse(course1);

		assertEquals(2, campus.getStudentCount());
	}

	@Test
	public void testGetCourseCount() {
		campus.addCourse(course1);
		assertEquals(1, campus.getCourseCount());
	}


}