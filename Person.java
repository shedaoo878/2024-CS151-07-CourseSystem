public abstract class Person {
    String name;
    String email;
    int id;
    Department department;
    Campus campus;

    public Person(String name, int id, String email, Department department, Campus campus){
        this.name = name;
        this.id = id;
        this.email = email;
        this.department = department;
        this.campus = campus;
    }

    String getName(){
        return name;
    };
    void printEmail(){
        System.out.println(email);
    };
    int getId(){
        return id;
    }
    void setDepartment(Department department){
        this.department = department;
    }
    void displayInfo(){
        System.out.println("Name: " + name + ", Email: " + email);
        System.out.println("Department: " + department.getName());
        System.out.println("Campus: " + campus.getCampusName());
        System.out.println("ID: " + id);

    };
}
