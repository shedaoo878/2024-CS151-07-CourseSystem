import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CampusTest {
    private Campus campus;
    private Department department;
    private Club club;
    private Course course;

    @BeforeEach
    public void setUp() {
        campus = new Campus("Main Campus", "123 University St", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        department = new Department("Computer Science", campus);
        club = new Club("Robotics Club", campus);
 
    }

    @Test
    public void testAddDepartment() {
        campus.addDepartment(department);
        assertTrue(campus.getDepartments().contains(department), "Department should be added to the campus.");
    }

    @Test
    public void testRemoveDepartment() {
        campus.addDepartment(department);
        campus.removeDepartment(department);
        assertFalse(campus.getDepartments().contains(department), "Department should be removed from the campus.");
    }

    @Test
    public void testAddClub() {
        campus.addClub(club);
        assertTrue(campus.getClubs().contains(club), "Club should be added to the campus.");
    }

    @Test
    public void testRemoveClub() {
        campus.addClub(club);
        campus.removeClub(club);
        assertFalse(campus.getClubs().contains(club), "Club should be removed from the campus.");
    }


    @Test
    public void testGetClubCount() {
        campus.addClub(club);
        assertEquals(1, campus.getClubCount(), "Club count should match the number of clubs added.");
    }

    @Test
    public void testFindDepartmentByName() {
        campus.addDepartment(department);
        assertEquals(department, campus.findDepartmentByName("Computer Science"), "Should return the department by its name.");
    }
}