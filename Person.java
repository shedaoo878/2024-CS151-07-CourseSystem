public abstract class Person {
    String name;
    String email;
    int id;
    Department department;
    Campus campus;
    String getName(){
        return name;
    };
    void printEmail(){
        System.out.println(email);
    };
    void displayInfo(){
        System.out.println("Name: " + name + ", Email: " + email);
        System.out.println("Department: " + department.getName());
        System.out.println("Campus: " + campus.getCampusName());
        System.out.println("ID: " + id);

    };
}
