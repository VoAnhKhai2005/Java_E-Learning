package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import util.LocalDateAdapter;
import java.time.LocalDate;
import pojo.WorkoutSchedule;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoJsonImpl implements ScheduleDao {
    private static final String FILE_PATH = "data/schedules.json";
    private List<WorkoutSchedule> schedules;
    private Gson gson;

    public ScheduleDaoJsonImpl() {
        this.schedules = new ArrayList<>();
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        loadAll();
    }

    @Override
    public void addSchedule(WorkoutSchedule schedule) {
        schedules.add(schedule);
        saveAll();
    }

    @Override
    public WorkoutSchedule getScheduleById(String id) {
        return schedules.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<WorkoutSchedule> getSchedulesByMemberId(String memberId) {
        return schedules.stream().filter(s -> s.getMemberId().equals(memberId)).toList();
    }

    @Override
    public List<WorkoutSchedule> getAllSchedules() {
        return new ArrayList<>(schedules);
    }

    @Override
    public void updateSchedule(WorkoutSchedule schedule) {
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId().equals(schedule.getId())) {
                schedules.set(i, schedule);
                saveAll();
                return;
            }
        }
    }

    @Override
    public void deleteSchedule(String id) {
        schedules.removeIf(s -> s.getId().equals(id));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(schedules, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAll() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<WorkoutSchedule>>(){}.getType();
            schedules = gson.fromJson(reader, listType);
            if (schedules == null) {
                schedules = new ArrayList<>();
            }
        } catch (IOException e) {
            schedules = new ArrayList<>();
        }
    }
}
