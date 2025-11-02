package dao;

import pojo.WorkoutSchedule;
import java.util.List;

public interface ScheduleDao {
    void addSchedule(WorkoutSchedule schedule);
    WorkoutSchedule getScheduleById(String id);
    List<WorkoutSchedule> getSchedulesByMemberId(String memberId);
    List<WorkoutSchedule> getAllSchedules();
    void updateSchedule(WorkoutSchedule schedule);
    void deleteSchedule(String id);
    void saveAll();
    void loadAll();
}
