package repository;

import dao.AttendanceDao;
import dao.AttendanceDaoJsonImpl;
import pojo.Attendance;
import java.util.List;

public class AttendanceRepository {
    private AttendanceDao attendanceDao;

    public AttendanceRepository() {
        this.attendanceDao = new AttendanceDaoJsonImpl();
    }

    public void addAttendance(Attendance attendance) {
        attendanceDao.addAttendance(attendance);
    }

    public Attendance getAttendanceById(String id) {
        return attendanceDao.getAttendanceById(id);
    }

    public List<Attendance> getAttendanceByMemberId(String memberId) {
        return attendanceDao.getAttendanceByMemberId(memberId);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceDao.getAllAttendance();
    }

    public void updateAttendance(Attendance attendance) {
        attendanceDao.updateAttendance(attendance);
    }

    public void deleteAttendance(String id) {
        attendanceDao.deleteAttendance(id);
    }

    public void saveAll() {
        attendanceDao.saveAll();
    }

    public void loadAll() {
        attendanceDao.loadAll();
    }
}
