import java.util.ArrayList;

public class Campus {
    private String campusName;
    private String location;
    private ArrayList<Department> departments;
    private ArrayList<Club> clubs;
    private ArrayList<Course> courses;

    public Campus(String campusName, String location) {
        this.campusName = campusName;
        this.location = location;
        this.departments = new ArrayList<>();
        this.clubs = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
            System.out.println("Department " + department.getName() + " added to campus " + campusName);
        } else {
            System.out.println("Department " + department.getName() + " already exists on campus.");
        }
    }

    public void removeDepartment(Department department) {
        if (departments.remove(department)) {
            System.out.println("Department " + department.getName() + " removed from campus " + campusName);
        } else {
            System.out.println("Department " + department.getName() + " does not exist on campus.");
        }
    }

    public void addClub(Club club) {
        if (!clubs.contains(club)) {
            clubs.add(club);
            System.out.println("Club " + club.getClubName() + " added to campus " + campusName);
        } else {
            System.out.println("Club " + club.getClubName() + " already exists on campus.");
        }
    }

    public void removeClub(Club club) {
        if (clubs.remove(club)) {
            System.out.println("Club " + club.getClubName() + " removed from campus " + campusName);
        } else {
            System.out.println("Club " + club.getClubName() + " does not exist on campus.");
        }
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course " + course.getTitle() + " added to campus " + campusName);
        } else {
            System.out.println("Course " + course.getTitle() + " already exists on campus.");
        }
    }

    public void removeCourse(Course course) {
        if (courses.remove(course)) {
            System.out.println("Course " + course.getTitle() + " removed from campus " + campusName);
        } else {
            System.out.println("Course " + course.getTitle() + " does not exist on campus.");
        }
    }

    public ArrayList<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    public ArrayList<Club> getClubs() {
        return new ArrayList<>(clubs);
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStudentCount() {
        int totalStudents = 0;
        for (Course course : courses) {
            totalStudents += course.getCurrentNumStudents(); // Assuming this method exists in Course
        }
        return totalStudents;
    }

    public int getClubCount() {
        return clubs.size();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public ArrayList<Course> getCoursesByDepartment(Department department) {
        ArrayList<Course> departmentCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equals(department)) {
                departmentCourses.add(course);
            }
        }
        return departmentCourses;
    }

    public ArrayList<Club> getAvailableClubs() {
        ArrayList<Club> availableClubs = new ArrayList<>();
        for (Club club : clubs) {
            if (!club.isFull()) {
                availableClubs.add(club);
            }
        }
        return availableClubs;
    }

    public void listCampusInfo() {
        System.out.println("Campus: " + campusName + " (Location: " + location + ")");
        System.out.println("Departments:");
        for (Department department : departments) {
            System.out.println(" - " + department.getName());
        }
        System.out.println("Clubs:");
        for (Club club : clubs) {
            System.out.println(" - " + club.getClubName());
        }
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(" - " + course.getTitle());
        }
        System.out.println("Total Students: " + getStudentCount());
    }

    @Override
    public String toString() {
        return "Campus: " + campusName + " (Location: " + location + ")";
    }
}
