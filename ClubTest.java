import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


//junit4
public class ClubTest {
    private Campus campus;
    private Club codingClub;
    private Student student1;
    private Student student2;

    @Before
    public void setUp() {
        campus = new Campus("Main Campus");

        codingClub = new Club("Coding Club", "A club for coding enthusiasts", campus, 2);
        
        student1 = new Student("Emily", 1, new Department("Computer Science", campus), 0, null, campus);
        student2 = new Student("Tyler", 2, new Department("Computer Science", campus), 0, null, campus);
    }

    @Test
    public void testRegisterStudent() {
        codingClub.register(student1);
        assertTrue(codingClub.hasMember(student1));
    }

    @Test
    public void testRegisterAlreadyMember() {
        codingClub.register(student1);
        codingClub.register(student1);
        assertEquals(1, codingClub.getMemberCount());
    }

    @Test
    public void testDropStudent() {
        codingClub.register(student1);
        codingClub.drop(student1);
        assertFalse(codingClub.hasMember(student1));
    }

    @Test
    public void testDropNonMember() {
        codingClub.drop(student1); 
        assertFalse(codingClub.hasMember(student1));
    }

    @Test
    public void testListMembers() {
        codingClub.register(student1);
        codingClub.register(student2);
        String expectedOutput = "Emily, Tyler"; 
        assertEquals(expectedOutput, codingClub.listMembers());
    }

    @Test
    public void testIsFull() {
        assertFalse(codingClub.isFull()); 
        codingClub.register(student1);
        codingClub.register(student2);
        assertTrue(codingClub.isFull()); 
    }

 
}