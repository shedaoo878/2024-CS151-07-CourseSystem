import java.util.ArrayList;

public class Club {
    private String clubName;
    private String description;
    private ArrayList<Student> members;
    private Campus campus;
    private int maxMembers;

    public Club(String clubName, String description, Campus campus, int maxMembers) {
        this.clubName = clubName;
        this.description = description;
        this.members = new ArrayList<>();
        this.campus = campus;
        this.maxMembers = maxMembers;
        campus.addClub(this);
    }

    public boolean addMember(Student student) {
        if (members.size() < maxMembers && !members.contains(student)) {
            members.add(student);
            return true;
        }
        return false;
    }

    public boolean removeMember(Student student) {
        return members.remove(student);
    }

    public ArrayList<Student> getMembers() {
        return new ArrayList<>(members);
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

    public boolean isFull() {
        return members.size() >= maxMembers;
    }

    public String listMembers() {
        if (members.isEmpty()) {
            return "No students are in this club.";
        } else {
            StringBuilder memberList = new StringBuilder();
            for (int i = 0; i < members.size(); i++) {
                memberList.append(members.get(i).getName());
                if (i < members.size() - 1) {
                    memberList.append(", ");
                }
            }
            return memberList.toString();
        }
    }

    public int getMemberCount() {
        return members.size();
    }

    public boolean hasMember(Student student) {
        return members.contains(student);
    }

    public String toString() {
        return "Club: " + clubName
                + " (Members: " + getMemberCount() + "/" + maxMembers + ")";
    }
}