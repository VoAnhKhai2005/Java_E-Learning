package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import util.LocalDateAdapter;
import java.time.LocalDate;
import pojo.Attendance;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoJsonImpl implements AttendanceDao {
    private static final String FILE_PATH = "data/attendance.json";
    private List<Attendance> attendances;
    private Gson gson;

    public AttendanceDaoJsonImpl() {
        this.attendances = new ArrayList<>();
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        loadAll();
    }

    @Override
    public void addAttendance(Attendance attendance) {
        attendances.add(attendance);
        saveAll();
    }

    @Override
    public Attendance getAttendanceById(String id) {
        return attendances.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Attendance> getAttendanceByMemberId(String memberId) {
        return attendances.stream().filter(a -> a.getMemberId().equals(memberId)).toList();
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return new ArrayList<>(attendances);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        for (int i = 0; i < attendances.size(); i++) {
            if (attendances.get(i).getId().equals(attendance.getId())) {
                attendances.set(i, attendance);
                saveAll();
                return;
            }
        }
    }

    @Override
    public void deleteAttendance(String id) {
        attendances.removeIf(a -> a.getId().equals(id));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(attendances, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAll() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Attendance>>(){}.getType();
            attendances = gson.fromJson(reader, listType);
            if (attendances == null) {
                attendances = new ArrayList<>();
            }
        } catch (IOException e) {
            attendances = new ArrayList<>();
        }
    }
}
