import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Professor extends Person implements Admin{
	
  	private String name;
	private ArrayList<Course> coursesTaught;
	private int profID;
	private Department dep;
	private String email;
	private ArrayList<LocalDateTime> officeHours;

	public Professor(String name, int id, String email, Department dep) {
		super(name, id, email, dep);
		this.name = name;
		this.id = id;
		this.email = email;
		this.dep = dep;
	}

	public Professor(String name, int id, String email, Department dep, Campus campus) {
		super(name, id, email, dep, campus);
		this.name = name;
		this.coursesTaught = new ArrayList<>();
		this.officeHours = new ArrayList<>();
		this.email = email;
		this.dep = dep;
		this.campus = campus;
		campus.addPerson(this);
	}


	
	public void printEmail(){
		System.out.println("Email: " + email);
	}
	
	public void addCourse(Course course) {
		if(!coursesTaught.contains(course)){
			coursesTaught.add(course);
			System.out.println(course.getTitle() + " successfully added for Professor's courses!");
		}
		else{
			System.out.print("Professor is already teaching this course!");
		}
		
	}
	
	public void removeCourse(Course course) {
		if(coursesTaught.contains(course)) {
			coursesTaught.remove(course);
			System.out.println(course.getTitle() + " successfully removed from Professor's courses!");
		}else {
			System.out.println("You can't remove a course the professor isn't teaching!");
		}
	}
	
	public void viewCourses() {
		System.out.println("All courses taught by Professor " + name + ": ");
		for(Course course: coursesTaught) {
			System.out.println(course.getTitle());
		}
	}
	
	public void scheduleOfficeHours(LocalDateTime time) {
	       officeHours.add(time);
	       System.out.println("Office hours scheduled at: " + time);
	   }
		
		public void viewOfficeHours() {
	       System.out.println("Office hours for Professor " + getName() + ":");
	       for (LocalDateTime time : officeHours) {
	           System.out.println(time);
	       }
		}

	public String getName() {
		return name;
	}
	public Department getDepartment(){
        return dep;
    }
    public void setDepartment(Department d){
        dep = d;
    }

	public int getEmployeeID() {
		return profID;
	}

	
	
	public void addGrade(Student s, Course c, char grade){
		c.setGrade(this, s, grade);
		System.out.println("Grade has been set to " + grade);
		System.out.println();
	}
	

	public void addAdmin(Student s, Course c){
		c.addAdmin(s);
	}
	

	@Override
	public void displayInfo() {
		System.out.println("Professor Name: " + getName());
    	System.out.println("Professor's ID: " + getEmployeeID());
    	System.out.println("Email: " + email);
    	System.out.println("Department: " + getDepartment().getName());
		
		
	}
	public Boolean checkIDinCourse(Course c, int id){
		for(Student s: c.getEnrolledStudentsList()){
			if(s.getStudentId() == id){
				return true;
			}
		}
		return false;
	}
	
	public void professorCourseManagement(Scanner s, Professor professor){
		System.out.println("COURSE MANAGEMENT SYSTEM");
		System.out.println("Enter the number to view actions for the corresponding course: ");

		int num = 1;
		for(Course course: coursesTaught) {
			System.out.println(num + ") " + course.getTitle());
			num++;
		}
		
		System.out.print("Please enter your choice (enter 0 to exit): ");
		int choice = s.nextInt();
		s.nextLine();

		while(choice != 0){
			if(choice > 0 && choice <= coursesTaught.size()){
				Course selectedCourse = coursesTaught.get(choice - 1);
				System.out.println();
				selectedCourse.printCourseInfo();
				System.out.println();
				System.out.println("1 - Add Student Grade");
				System.out.println("2 - Assign a Student Admin");
				System.out.println("3 - Schedule Office Hours");
				System.out.println();
				System.out.print("Please enter your choice (enter 0 to exit): ");
				int choice2 = s.nextInt();
				s.nextLine();

				while(choice2 != 0){
					if(choice2 == 1){
						System.out.print("Enter the student's ID: ");
						int id = s.nextInt();
						s.nextLine();		
						if(checkIDinCourse(selectedCourse, id)){
							System.out.print("Enter the grade: ");
							char grade = s.next().charAt(0);
							s.nextLine();
							addGrade(selectedCourse.getStudent(id), selectedCourse, grade);	
						}
						else{
							System.out.println("This student is not in this course.");
						}
					
					}
					else if(choice2 == 2){
						System.out.print("Enter the student's ID: ");
						int id = s.nextInt();
						s.nextLine();
						if(checkIDinCourse(selectedCourse, id)){
							addAdmin(selectedCourse.getStudent(id), selectedCourse);
						}
						else{
							System.out.println("This student is not in this course.");
						}
					}
				}

						



			}
		}

	
		
	}

}

