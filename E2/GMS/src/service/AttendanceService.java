package service;

import pojo.Attendance;
import repository.AttendanceRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private AttendanceRepository attendanceRepository;

    public AttendanceService() {
        this.attendanceRepository = new AttendanceRepository();
    }

    public void addAttendance(String id, String memberId, LocalDate date, boolean present) {
        Attendance attendance = new Attendance(id, memberId, date, present);
        attendanceRepository.addAttendance(attendance);
    }

    public Attendance getAttendanceById(String id) {
        return attendanceRepository.getAttendanceById(id);
    }

    public List<Attendance> getAttendanceByMemberId(String memberId) {
        return attendanceRepository.getAttendanceByMemberId(memberId);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.getAllAttendance();
    }

    public void updateAttendance(Attendance attendance) {
        attendanceRepository.updateAttendance(attendance);
    }

    public void deleteAttendance(String id) {
        attendanceRepository.deleteAttendance(id);
    }

    public double getAttendancePercentage(String memberId) {
        List<Attendance> attendances = getAttendanceByMemberId(memberId);
        if (attendances.isEmpty()) return 0.0;
        long presentCount = attendances.stream().filter(Attendance::isPresent).count();
        return (double) presentCount / attendances.size() * 100;
    }

    public List<Attendance> getAttendanceForDate(LocalDate date) {
        return attendanceRepository.getAllAttendance().stream()
                .filter(a -> a.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
