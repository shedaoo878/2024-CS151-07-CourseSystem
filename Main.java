import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    
    private static List<Course> courses = new ArrayList<>();
    private static List<Club> clubs = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Campus sjsu = new Campus("SJSU");
        Department cs = new Department("CS", sjsu);

        Student bob = new Student("Bob", 3, cs, 1, "ww");
        Professor trev = new Professor("trv", 1, "wwww");
        
        Course course1 = new Course(trev, 3, cs, 30,"CS146", true, new ArrayList<String>());
        courses.add(course1);

        Club club1 = new Club("Robotics", "Builds robots and other stuff.", sjsu, 20);
        Club club2 = new Club("OOP club", "We learn about OOP.", sjsu, 8);
        clubs.add(club1);
        clubs.add(club2);

        
        studentMainMenu(s, bob);

    }

    public static void studentMainMenu(Scanner s, Student student) {
        boolean exit = false;
        while (!exit) {
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
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
}
