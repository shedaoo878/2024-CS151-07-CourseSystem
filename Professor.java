public class Professor implements Person {
    private String name;
    private String email;
    // ... other Professor-specific fields ...

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    // ... other Professor-specific methods ...
}
