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
        
        try {
            Campus sjsu = new Campus("SJSU");
            Department cs = new Department("CS", sjsu);
            Department business = new Department("Business", sjsu);
            Student bob = new Student("Bob", 3, cs, 1, "ww", sjsu);
            Professor trev = new Professor("Dr. Trev", 1, "wwww", cs, sjsu);
            Professor jensen = new Professor("Dr. Jensen", 2, "wwty", business, sjsu);
            
            Course course1 = new Course(trev, 3, cs, 30, "CS146", new ArrayList<String>(), 1);
            Course course2 = new Course(jensen, 3, business, 30, "BUS4118D", new ArrayList<String>(), 2);
            Course course3 = new Course(trev, 3, cs, 30, "CS151", new ArrayList<String>(), 3);
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
            

            System.out.println("----------------");
            System.out.println("Student Menu [1] - Professor Menu [2] - Department Menu [3]");
            int choice = s.nextInt();
            if(choice == 1){
                studentMainMenu(s, bob);
            }
            else if(choice == 2){
                professorMainMenu(s, trev);
            }
            else if(choice == 3){
                departmentMainMenu(s, cs);
            }
            else{
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            s.close();
        }
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
                        System.out.println();
                        break;
                    case 2:
                        student.addClasses(s, courses);
                        System.out.println();
                        break;
                    case 3:
                        student.joinClubs(s, clubs);
                        System.out.println();
                        break;
                    case 4:
                        student.displayInfo();
                        System.out.println();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine(); 
                
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public static void professorMainMenu(Scanner s, Professor professor){
        boolean exit = false;
        while (!exit) {
            System.out.println("WELCOME TO THE PROFESSOR MAIN MENU");
            System.out.println("1 - Course Management");
            System.out.println("2 - View Info");
            System.out.println("3 - Exit");
            System.out.println();
            System.out.print("Please enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    professor.professorCourseManagement(s, professor);
                    break;
                case 2:
                    professor.displayInfo();
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }   
    }

	public static void departmentMainMenu(Scanner s, Department department) {
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("\nDEPARTMENT MANAGEMENT SYSTEM");
				System.out.println("1 - Change Department of Person");
				System.out.println("2 - Change Department of Course");
				System.out.println("3 - View Department Courses");
				System.out.println("4 - Exit");
				System.out.print("Please enter your choice: ");

				int choice = s.nextInt();
				s.nextLine();

				switch (choice) {
				case 1:
					System.out.println("You have selected to switch a person's department. Enter the ID of the person: ");
					int id = s.nextInt();
					s.nextLine();
					department.changePersonDepartment(id);
					break;
				case 2:
					System.out.println("You have selected to switch a course's department. Enter the ID of the course: ");
					int courseId = s.nextInt();
					s.nextLine();
					department.changeCourseDepartment(courseId);
					break;
				case 3:
					System.out.println("\nCourses in this department: ");
					for (Course course : courses) {
						course.getTitle();
					}
					break;
				case 4:
					exit = true;
					System.out.println("Exiting department management system.");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 4.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				s.nextLine();
			} catch (Exception e) {
				System.out.println("An error occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	
}
