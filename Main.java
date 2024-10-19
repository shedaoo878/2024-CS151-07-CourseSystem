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

			Student bob = new Student("Bob", 3, cs, 1, "password", sjsu);

			Professor trev = new Professor("Dr. Trev", 1, "password", cs);
			Professor jensen = new Professor("Dr. Jensen", 2, "password", cs);

			Course course1 = new Course(trev, 3, cs, 30, "CS146", true, new ArrayList<>(), "Duncan Hall 412");
			Course course2 = new Course(jensen, 3, cs, 30, "BUS118D", true, new ArrayList<>(), "BBC 320");
			Course course3 = new Course(trev, 3, cs, 30, "CS151", true, new ArrayList<>(), "Duncan Hall 416");
			courses.add(course1);
			courses.add(course2);
			courses.add(course3);

			Club club1 = new Club("Robotics", "Builds robots and other stuff.", sjsu, 20);
			Club club2 = new Club("OOP Club", "We learn about OOP.", sjsu, 8);
			Club club3 = new Club("MISA", "Learn about careers in MIS.", sjsu, 70);
			clubs.add(club1);
			clubs.add(club2);
			clubs.add(club3);

			// Office Hours
			LocalDateTime LDT1 = LocalDateTime.of(2024, 10, 20, 14, 0);
			LocalDateTime LDT2 = LocalDateTime.of(2024, 10, 22, 14, 0);
			LocalDateTime LDT3 = LocalDateTime.of(2024, 10, 20, 15, 30);
			LocalDateTime LDT4 = LocalDateTime.of(2024, 10, 22, 15, 30);
			trev.scheduleOfficeHours(LDT1);
			trev.scheduleOfficeHours(LDT2);
			jensen.scheduleOfficeHours(LDT3);
			jensen.scheduleOfficeHours(LDT4);

			// Professor
			trev.addCourse(course1);
			trev.addCourse(course3);
			jensen.addCourse(course2);

			// Students
			cs.addStudent(bob);

			boolean exit = false;
			while (!exit) {
				System.out.println("\nWELCOME TO THE CAMPUS SYSTEM");
				System.out.println("1 - Enter as Student");
				System.out.println("2 - Enter as Admin");
				System.out.println("3 - Exit");
				System.out.print("Please enter your choice: ");

				int choice = s.nextInt();
				s.nextLine();

				switch (choice) {
				case 1:
					studentMainMenu(s, bob); // STUDENT
					break;
				case 2:
					departmentMainMenu(s, cs); // ADMIN
					break;
				case 3:
					exit = true;
					System.out.println("Exiting the system. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 3.");
				}
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
				System.out.println("\nWELCOME TO THE STUDENT MENU");
				System.out.println("1 - View Schedule");
				System.out.println("2 - Add Classes");
				System.out.println("3 - Join Clubs");
				System.out.println("4 - View Info");
				System.out.println("5 - Exit");
				System.out.print("Please enter your choice: ");

				int choice = s.nextInt();
				s.nextLine();

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
					System.out.println("Exiting to main menu.");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 5.");
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

	public static void departmentMainMenu(Scanner s, Department department) {
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("\nDEPARTMENT MANAGEMENT SYSTEM");
				System.out.println("1 - Approve Course");
				System.out.println("2 - Remove Student");
				System.out.println("3 - View Available Courses");
				System.out.println("4 - Exit");
				System.out.print("Please enter your choice: ");

				int choice = s.nextInt();
				s.nextLine();

				switch (choice) {
				case 1:
					System.out.print("Enter course title to approve: ");
					String courseTitle = s.nextLine();
					Course courseToApprove = findCourseByTitle(courseTitle);
					if (courseToApprove != null) {
						department.approveCourse(courseToApprove);
					} else {
						System.out.println("Course not found.");
					}
					break;
				case 2:
					System.out.print("Enter student name to remove: ");
					String studentName = s.nextLine();
					Student studentToRemove = findStudentByName(studentName, department);
					if (studentToRemove != null) {
						department.removeStudent(studentToRemove);
					} else {
						System.out.println("Student not found in the department.");
					}
					break;
				case 3:
					System.out.println("\n--- Available Courses ---");
					for (Course course : courses) {
						course.printCourseInfo();
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

	private static Course findCourseByTitle(String title) {
		for (Course course : courses) {
			if (course.getTitle().equalsIgnoreCase(title)) {
				return course;
			}
		}
		return null;
	}

	private static Student findStudentByName(String name, Department department) {
		for (Student student : department.getStudentsInDep()) {
			if (student.getName().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}
}
