package dao;

import pojo.Attendance;
import java.util.List;

public interface AttendanceDao {
    void addAttendance(Attendance attendance);
    Attendance getAttendanceById(String id);
    List<Attendance> getAttendanceByMemberId(String memberId);
    List<Attendance> getAllAttendance();
    void updateAttendance(Attendance attendance);
    void deleteAttendance(String id);
    void saveAll();
    void loadAll();
}
