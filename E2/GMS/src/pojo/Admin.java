package pojo;

public class Admin extends User {
    public Admin() {}

    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password, "Admin");
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
