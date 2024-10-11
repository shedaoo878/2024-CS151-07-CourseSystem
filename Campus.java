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
        }
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public void addClub(Club club) {
        if (!clubs.contains(club)) {
            clubs.add(club);
        }
    }

    public void removeClub(Club club) {
        clubs.remove(club);
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
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
            totalStudents += course.getEnrolledStudents().size();
        }
        return totalStudents;
    }

    public int getClubCount() {
        return clubs.size();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public ArrayList<Course> getCoursesByDepartment(String department) {
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

    public String toString() {
        return "Campus: " + campusName
                + " (Location: " + location + ")";
    }
}