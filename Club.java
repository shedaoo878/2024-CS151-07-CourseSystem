import java.util.ArrayList;
import java.util.List;

public class Club implements Registerable {
    private String clubName;
    private String description;
    private final List<Student> members = new ArrayList<>();
    private final Campus campus;
    private int maxMembers;

    // Consolidated constructor with default values for optional parameters
    public Club(String clubName, String description, Campus campus, int maxMembers) {
        this.clubName = clubName;
        this.description = (description != null) ? description : "";
        this.campus = campus;
        this.maxMembers = (maxMembers > 0) ? maxMembers : 10;
        campus.addClub(this);
    }

    public Club(String clubName, Campus campus) {
        this(clubName, "", campus, 10);
    }

    @Override
    public void register(Student student) {
        if (student == null || members.contains(student)) {
            printErrorMessage(student, "already registered or invalid");
        } else if (isFull()) {
            printErrorMessage(student, "club is full");
        } else {
            members.add(student);
            student.addToClubs(this);
            System.out.println(student.getName() + " has been registered for the club: " + clubName);
        }
    }

    @Override
    public void drop(Student student) {
        if (student == null || !members.contains(student)) {
            printErrorMessage(student, "not a member or invalid");
        } else {
            members.remove(student);
            System.out.println(student.getName() + " has been dropped from the club: " + clubName);
        }
    }

    // Consolidated error message handling
    private void printErrorMessage(Student student, String reason) {
        String name = (student != null) ? student.getName() : "Unknown";
        System.out.println("Error: " + name + " - " + reason + " for the club: " + clubName);
    }

    public String listMembers() {
        return members.isEmpty() ? "No students are in this club." : String.join(", ", members.stream().map(Student::getName).toList());
    }

    public boolean isFull() {
        return members.size() >= maxMembers;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
        System.out.println("Club description updated for " + clubName);
    }

    public boolean isStudentMember(Student student) {
        return members.contains(student);
    }

    public void printClubAnnouncement(String announcement) {
        System.out.println("Announcement for " + clubName + ": " + announcement);
    }

    public void printClubDetails() {
        System.out.println("Club Name: " + clubName);
        System.out.println("Description: " + description);
        System.out.println("Members: " + members.size() + "/" + maxMembers);
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Campus getCampus() {
        return campus;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public int getMemberCount() {
        return members.size();
    }

    public boolean hasMember(Student student) {
        return members.contains(student);
    }

    @Override
    public String toString() {
        return "Club: " + clubName + " (Members: " + getMemberCount() + "/" + maxMembers + ")";
    }
}
