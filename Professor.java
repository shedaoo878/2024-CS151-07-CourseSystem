package courseSystem;
import java.util.ArrayList;
import java.util.Scanner;



public class Professor {
	
	private String name;
	private String education;
	private ArrayList<Course> coursesTaught;
	private String contactInfo;
	private String employeeID;
	private String department;
	
	
	 public Professor(String name, String education, String contactInfo, String department, String employeeID) {
		this.name = name;
		this.education = education;
		this.coursesTaught = new ArrayList<>();
		this.contactInfo = contactInfo;
		this.setDepartment(department);
		
	}
	
	
	public void addCourse(Course course) {
		coursesTaught.add(course);
		System.out.println(course.getTitle() + " successfully added!");
	}
	
	public void removeCourse(Course course) {
		if(coursesTaught.contains(course)) {
			coursesTaught.remove(course);
			System.out.println(course.getTitle() + " successfully removed!");
		}else {
			System.out.println("You can't remove a course the professor isn't teaching! :c");
		}
	}
	
	public void viewCourses() {
		System.out.println("All courses taught by Professor " + name + ": ");
		for(Course course: coursesTaught) {
			System.out.println(course.getTitle());
		}
	}
	
	public void updateContactInfo(String newContactInfo) {
        this.setContactInfo(newContactInfo);
        System.out.println("Contact information updated for Professor " + name);
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	
	public void setEducation(String education) {
		this.education = education;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
  }
	
}
