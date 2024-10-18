import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Main {
    
    private static List<Course> courses = new ArrayList<>();
    private static List<Club> clubs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
<<<<<<< HEAD
        Campus sjsu = new Campus("SJSU");

        Department cs = new Department("CS", sjsu);
        Department business = new Department("Business", sjsu);

        Student bob = new Student("Bob", 3, cs, 1, "ww", sjsu);
        Professor trev = new Professor("trv", 1, "wwww");
        Professor jensen = new Professor("Jensen", 2, "wwty");
        
        Course course1 = new Course(trev, 3, cs, 30,"CS146", true, new ArrayList<String>());
        Course course2 = new Course(jensen, 3, business, 30, "BUS4118D", true, new ArrayList<String>());
        Course course3 = new Course(trev, 3, cs, 30,"CS151", true, new ArrayList<String>());
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        Club club1 = new Club("Robotics", "Builds robots and other stuff.", sjsu, 20);
        Club club2 = new Club("OOP club", "We learn about OOP.", sjsu, 8);
        Club club3 = new Club("MISA", "Learn about careers in MIS.", sjsu, 70);
        clubs.add(club1);
        clubs.add(club2);
        clubs.add(club3);

        studentMainMenu(s, bob);

=======
        try {
            Campus sjsu = new Campus("SJSU");
            Department cs = new Department("CS", sjsu);
            Department business = new Department("Business", sjsu);
            Student bob = new Student("Bob", 3, cs, 1, "ww", sjsu);
            Professor trev = new Professor("Dr. Trev", 1, "wwww", cs);
            Professor jensen = new Professor("Dr. Jensen", 2, "wwty", business);
            
            Course course1 = new Course(trev, 3, cs, 30, "CS146", true, new ArrayList<String>(), "Duncan Hall 412");
            Course course2 = new Course(jensen, 3, business, 30, "BUS4118D", true, new ArrayList<String>(), "BBC 320");
            Course course3 = new Course(trev, 3, cs, 30, "CS151", true, new ArrayList<String>(), "Duncan Hall 416");
            courses.add(course1);
            courses.add(course2);
            courses.add(course3);
            
            Club club1 = new Club("Robotics", "Builds robots and other stuff.", sjsu, 20);
            Club club2 = new Club("OOP club", "We learn about OOP.", sjsu, 8);
            Club club3 = new Club("MISA", "Learn about careers in MIS.", sjsu, 70);
            clubs.add(club1);
            clubs.add(club2);
            clubs.add(club3);
            
            LocalDateTime LDT1 = LocalDateTime.of(2024, 10, 20, 14, 0);
            LocalDateTime LDT2 = LocalDateTime.of(2024, 10, 22, 14, 0);
            LocalDateTime LDT3 = LocalDateTime.of(2024, 10, 20, 15, 30);
            LocalDateTime LDT4 = LocalDateTime.of(2024, 10, 22, 15, 30);
            
            trev.scheduleOfficeHours(LDT1);
            trev.scheduleOfficeHours(LDT2);
            jensen.scheduleOfficeHours(LDT3);
            jensen.scheduleOfficeHours(LDT4);
            
            trev.viewOfficeHours();
            jensen.viewOfficeHours();
            trev.viewCourses();
            jensen.viewCourses();
            
            trev.addCourse(course1);
            trev.addCourse(course3);
            jensen.addCourse(course2);
            
            trev.displayInfo();
            jensen.displayInfo();
            
            studentMainMenu(s, bob);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            s.close();
        }
>>>>>>> main
    }

    public static void studentMainMenu(Scanner s, Student student) {
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("WELCOME TO THE CAMPUS SYSTEM");
                System.out.println("1 - View Schedule");
                System.out.println("2 - Add Classes");
                System.out.println("3 - Join Clubs");
                System.out.println("4 - View Info");
                System.out.println("5 - Exit");
                System.out.println();
                System.out.print("Please enter your choice: ");
                
                int choice = s.nextInt();
                s.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        student.printSchedule();
                        break;
                    case 2:
                        student.addClasses(s, courses);
                        break;
                    case 3:
                        student.joinClubs(s, clubs);
                        break;
                    case 4:
                        student.displayInfo();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine(); // Clears the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
