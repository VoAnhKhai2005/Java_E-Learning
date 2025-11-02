package pojo;

import java.time.LocalDate;
import java.util.List;

public class WorkoutSchedule {
    private String id;
    private String memberId;
    private String trainerId;
    private LocalDate date;
    private List<String> exercises;
    private String progress; // e.g., "Completed", "In Progress", "Not Started"

    public WorkoutSchedule() {}

    public WorkoutSchedule(String id, String memberId, String trainerId, LocalDate date, List<String> exercises, String progress) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.date = date;
        this.exercises = exercises;
        this.progress = progress;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getTrainerId() { return trainerId; }
    public void setTrainerId(String trainerId) { this.trainerId = trainerId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public List<String> getExercises() { return exercises; }
    public void setExercises(List<String> exercises) { this.exercises = exercises; }

    public String getProgress() { return progress; }
    public void setProgress(String progress) { this.progress = progress; }

    @Override
    public String toString() {
        return "WorkoutSchedule{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", trainerId='" + trainerId + '\'' +
                ", date=" + date +
                ", exercises=" + exercises +
                ", progress='" + progress + '\'' +
                '}';
    }
}
