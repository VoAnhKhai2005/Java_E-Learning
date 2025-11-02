package pojo;

import java.time.LocalDate;

public class Attendance {
    private String id;
    private String memberId;
    private LocalDate date;
    private boolean present;

    public Attendance() {}

    public Attendance(String id, String memberId, LocalDate date, boolean present) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
        this.present = present;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isPresent() { return present; }
    public void setPresent(boolean present) { this.present = present; }

    @Override
    public String toString() {
        return "Attendance{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", date=" + date +
                ", present=" + present +
                '}';
    }
}
