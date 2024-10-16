import java.util.ArrayList;
import java.time.LocalDateTime;



public class Professor implements Person {
	
  	private String name;
	private ArrayList<Course> coursesTaught;
	private int profID;
	private Department dep;
	private String email;

	
	public Professor(String name, int id, String email) {
		this.name = name;
		this.coursesTaught = new ArrayList<>();
		this.email = email;
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


	public void setEmployeeID(int employeeID) {
		this.profID = employeeID;
	}
	

	@Override
	public void displayInfo() {
		System.out.println("Professor Name: " + getName());
    	System.out.println("Professor's ID: " + getEmployeeID());
	
		
	  }
}

