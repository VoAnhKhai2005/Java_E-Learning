package pojo;

import java.time.LocalDate;

public class Member extends User {
    private String subscriptionId;
    private LocalDate joinDate;
    private LocalDate expiryDate;
    private boolean isActive;

    public Member() {}

    public Member(String id, String name, String email, String password, String subscriptionId, LocalDate joinDate, LocalDate expiryDate, boolean isActive) {
        super(id, name, email, password, "Member");
        this.subscriptionId = subscriptionId;
        this.joinDate = joinDate;
        this.expiryDate = expiryDate;
        this.isActive = isActive;
    }

    // Getters and Setters
    public String getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; }

    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", joinDate=" + joinDate +
                ", expiryDate=" + expiryDate +
                ", isActive=" + isActive +
                '}';
    }
}
