import pojo.User;
import service.AuthService;
import service.MemberService;
import service.ScheduleService;
import service.AttendanceService;
import service.ReportService;
import pojo.Member;
import pojo.WorkoutSchedule;
import pojo.Attendance;
import pojo.Report;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static AuthService authService = new AuthService();
    private static MemberService memberService = new MemberService();
    private static ScheduleService scheduleService = new ScheduleService();
    private static AttendanceService attendanceService = new AttendanceService();
    private static ReportService reportService = new ReportService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Gym Management System (GMS)");

        while (true) {
            System.out.println("\n--- Login ---");
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = authService.login(email, password);
            if (user != null) {
                System.out.println("Login successful! Role: " + user.getRole());
                switch (user.getRole()) {
                    case "Admin":
                        adminMenu();
                        break;
                    case "Trainer":
                        trainerMenu(user.getId());
                        break;
                    case "Member":
                        memberMenu(user.getId());
                        break;
                }
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Manage Members");
            System.out.println("2. Manage Trainers");
            System.out.println("3. Manage Subscription Plans");
            System.out.println("4. Generate Reports");
            System.out.println("5. Logout");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manageMembers();
                    break;
                case 2:
                    manageTrainers();
                    break;
                case 3:
                    managePlans();
                    break;
                case 4:
                    generateReports();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void manageMembers() {
        System.out.println("\n--- Manage Members ---");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Update Member");
        System.out.println("4. Delete Member");
        System.out.print("Choose option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                System.out.print("Subscription ID: ");
                String subId = scanner.nextLine();
                LocalDate joinDate = LocalDate.now();
                LocalDate expiryDate = joinDate.plusMonths(1);
                memberService.addMember(id, name, email, password, subId, joinDate, expiryDate, true);
                System.out.println("Member added.");
                break;
            case 2:
                List<Member> members = memberService.getAllMembers();
                members.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Member ID to update: ");
                String updateId = scanner.nextLine();
                Member member = memberService.getMemberById(updateId);
                if (member != null) {
                    System.out.print("New Name: ");
                    member.setName(scanner.nextLine());
                    memberService.updateMember(member);
                    System.out.println("Member updated.");
                } else {
                    System.out.println("Member not found.");
                }
                break;
            case 4:
                System.out.print("Member ID to delete: ");
                String deleteId = scanner.nextLine();
                memberService.deleteMember(deleteId);
                System.out.println("Member deleted.");
                break;
        }
    }

    private static void manageTrainers() {
        System.out.println("Trainers management not fully implemented yet.");
    }

    private static void managePlans() {
        System.out.println("Subscription plans management not fully implemented yet.");
    }

    private static void generateReports() {
        System.out.println("\n--- Generate Reports ---");
        System.out.println("1. Revenue Report");
        System.out.println("2. Membership Report");
        System.out.println("3. Attendance Report");
        System.out.println("4. Top Performers Report");
        System.out.print("Choose option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        Report report = null;
        switch (choice) {
            case 1:
                report = reportService.generateRevenueReport();
                break;
            case 2:
                report = reportService.generateMembershipReport();
                break;
            case 3:
                report = reportService.generateAttendanceReport();
                break;
            case 4:
                report = reportService.generateTopPerformersReport();
                break;
        }
        if (report != null) {
            System.out.println("Report: " + report.getType());
            report.getData().forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

    private static void trainerMenu(String trainerId) {
        while (true) {
            System.out.println("\n--- Trainer Menu ---");
            System.out.println("1. Assign Workout Schedule");
            System.out.println("2. Track Attendance");
            System.out.println("3. View Member Progress");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Schedule ID: ");
                    String schedId = scanner.nextLine();
                    System.out.print("Member ID: ");
                    String memId = scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Exercises (comma-separated): ");
                    List<String> exercises = Arrays.asList(scanner.nextLine().split(","));
                    scheduleService.addSchedule(schedId, memId, trainerId, date, exercises, "Not Started");
                    System.out.println("Schedule assigned.");
                    break;
                case 2:
                    System.out.print("Attendance ID: ");
                    String attId = scanner.nextLine();
                    System.out.print("Member ID: ");
                    String attMemId = scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate attDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Present (true/false): ");
                    boolean present = Boolean.parseBoolean(scanner.nextLine());
                    attendanceService.addAttendance(attId, attMemId, attDate, present);
                    System.out.println("Attendance recorded.");
                    break;
                case 3:
                    System.out.print("Member ID: ");
                    String progMemId = scanner.nextLine();
                    List<WorkoutSchedule> schedules = scheduleService.getSchedulesByMemberId(progMemId);
                    schedules.forEach(System.out::println);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void memberMenu(String memberId) {
        while (true) {
            System.out.println("\n--- Member Menu ---");
            System.out.println("1. View Workout Schedules");
            System.out.println("2. Update Progress");
            System.out.println("3. Renew Subscription");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    List<WorkoutSchedule> schedules = scheduleService.getSchedulesByMemberId(memberId);
                    schedules.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Schedule ID: ");
                    String schedId = scanner.nextLine();
                    System.out.print("New Progress: ");
                    String progress = scanner.nextLine();
                    scheduleService.updateProgress(schedId, progress);
                    System.out.println("Progress updated.");
                    break;
                case 3:
                    Member member = memberService.getMemberById(memberId);
                    if (member != null) {
                        member.setExpiryDate(member.getExpiryDate().plusMonths(1));
                        member.setActive(true);
                        memberService.updateMember(member);
                        System.out.println("Subscription renewed.");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
