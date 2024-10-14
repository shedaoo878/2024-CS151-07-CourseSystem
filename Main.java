import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        

        Student bob = new Student("Bob", 3, "CS", 1, "ww");
        Professor trev = new Professor("trv", 1, "wwww");
        studentMainMenu(s, bob);
    }

    public static void studentMainMenu(Scanner s, Student student) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Campus System");
            System.out.println("1 - View Schedule");
            System.out.println("2 - Add Classes");
            System.out.println("3 - Join Clubs");
            System.out.println("4 - View Info");
            System.out.println("5 - Exit");
            System.out.print("Please enter your choice: ");

            int choice = s.nextInt();
            s.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    student.printSchedule();
                    break;
                case 2:
                   // addClasses();
                    break;
                case 3:
                    //joinClubs();
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
