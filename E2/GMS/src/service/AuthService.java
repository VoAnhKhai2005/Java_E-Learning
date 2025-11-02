package service;

import pojo.Admin;
import pojo.Member;
import pojo.Trainer;
import pojo.User;
import repository.MemberRepository;
import repository.ScheduleRepository;
import repository.AttendanceRepository;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users;

    public AuthService() {
        this.users = new ArrayList<>();
        // Initialize with default users for demo
        users.add(new Admin("admin1", "Admin User", "admin@gym.com", "admin123"));
        users.add(new Trainer("trainer1", "Trainer One", "trainer1@gym.com", "trainer123", "Fitness"));
        users.add(new Member("member1", "Member One", "member1@gym.com", "member123", "sub1", java.time.LocalDate.now(), java.time.LocalDate.now().plusMonths(1), true));
    }

    public User login(String email, String password) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsersByRole(String role) {
        return users.stream()
                .filter(u -> u.getRole().equals(role))
                .toList();
    }
}
