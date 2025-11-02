package pojo;

public class Trainer extends User {
    private String specialization;

    public Trainer() {}

    public Trainer(String id, String name, String email, String password, String specialization) {
        super(id, name, email, password, "Trainer");
        this.specialization = specialization;
    }

    // Getters and Setters
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return "Trainer{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
