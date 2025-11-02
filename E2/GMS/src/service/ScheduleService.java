package service;

import pojo.WorkoutSchedule;
import repository.ScheduleRepository;
import java.time.LocalDate;
import java.util.List;

public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService() {
        this.scheduleRepository = new ScheduleRepository();
    }

    public void addSchedule(String id, String memberId, String trainerId, LocalDate date, List<String> exercises, String progress) {
        WorkoutSchedule schedule = new WorkoutSchedule(id, memberId, trainerId, date, exercises, progress);
        scheduleRepository.addSchedule(schedule);
    }

    public WorkoutSchedule getScheduleById(String id) {
        return scheduleRepository.getScheduleById(id);
    }

    public List<WorkoutSchedule> getSchedulesByMemberId(String memberId) {
        return scheduleRepository.getSchedulesByMemberId(memberId);
    }

    public List<WorkoutSchedule> getAllSchedules() {
        return scheduleRepository.getAllSchedules();
    }

    public void updateSchedule(WorkoutSchedule schedule) {
        scheduleRepository.updateSchedule(schedule);
    }

    public void deleteSchedule(String id) {
        scheduleRepository.deleteSchedule(id);
    }

    public void updateProgress(String scheduleId, String progress) {
        WorkoutSchedule schedule = getScheduleById(scheduleId);
        if (schedule != null) {
            schedule.setProgress(progress);
            updateSchedule(schedule);
        }
    }
}
