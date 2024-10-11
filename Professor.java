package courseSystem;
import java.util.ArrayList;
import java.time.LocalDateTime;



public class Professor extends Person {
	
  private String name;
	private String education;
	private ArrayList<Course> coursesTaught;
	private String contactInfo;
	private String employeeID;
	private double reviews;
	private ArrayList<LocalDateTime> officeHours;
	
	
	 public Professor(String name, String education, String contactInfo, String id) {
		super(name,id,contactInfo);
		this.education = education;
		this.coursesTaught = new ArrayList<>();
	}
	
	
	public void addCourse(Course course) {
		coursesTaught.add(course);
		System.out.println(course.getTitle() + " successfully added for Professor's courses!");
	}
	
	public void removeCourse(Course course) {
		if(coursesTaught.contains(course)) {
			coursesTaught.remove(course);
			System.out.println(course.getTitle() + " successfully removed from Professor's courses!");
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


	public double getReviews() {
		return reviews;
	}


	public void setReviews(double reviews) {
		this.reviews = reviews;
	}
	
	


	@Override
	public void displayInfo() {
		System.out.println("Professor Name: " + getName());
		System.out.println("Education: " + getContactInfo());
		System.out.println("ContactInfo: " + getContactInfo());
    System.out.println("Professor's ID: " + getEmployeeID());
		System.out.println("Review: " + getReviews());
		
	  }
}

