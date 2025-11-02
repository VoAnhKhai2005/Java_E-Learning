package repository;

import dao.ScheduleDao;
import dao.ScheduleDaoJsonImpl;
import pojo.WorkoutSchedule;
import java.util.List;

public class ScheduleRepository {
    private ScheduleDao scheduleDao;

    public ScheduleRepository() {
        this.scheduleDao = new ScheduleDaoJsonImpl();
    }

    public void addSchedule(WorkoutSchedule schedule) {
        scheduleDao.addSchedule(schedule);
    }

    public WorkoutSchedule getScheduleById(String id) {
        return scheduleDao.getScheduleById(id);
    }

    public List<WorkoutSchedule> getSchedulesByMemberId(String memberId) {
        return scheduleDao.getSchedulesByMemberId(memberId);
    }

    public List<WorkoutSchedule> getAllSchedules() {
        return scheduleDao.getAllSchedules();
    }

    public void updateSchedule(WorkoutSchedule schedule) {
        scheduleDao.updateSchedule(schedule);
    }

    public void deleteSchedule(String id) {
        scheduleDao.deleteSchedule(id);
    }

    public void saveAll() {
        scheduleDao.saveAll();
    }

    public void loadAll() {
        scheduleDao.loadAll();
    }
}
