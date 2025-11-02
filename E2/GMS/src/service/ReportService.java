package service;

import pojo.Member;
import pojo.Report;
import pojo.Subscription;
import pojo.WorkoutSchedule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {
    private MemberService memberService;
    private ScheduleService scheduleService;
    private AttendanceService attendanceService;

    public ReportService() {
        this.memberService = new MemberService();
        this.scheduleService = new ScheduleService();
        this.attendanceService = new AttendanceService();
    }

    public Report generateRevenueReport() {
        List<Member> members = memberService.getAllMembers();
        double totalRevenue = members.stream()
                .filter(Member::isActive)
                .mapToDouble(m -> {
                    // Assuming subscription price is stored or calculated; for simplicity, use a fixed price or add logic
                    return 50.0; // Placeholder price
                })
                .sum();

        Map<String, Object> data = new HashMap<>();
        data.put("totalRevenue", totalRevenue);
        data.put("activeMembers", memberService.getActiveMemberCount());

        return new Report("revenue-report", "Revenue", data);
    }

    public Report generateMembershipReport() {
        int activeCount = memberService.getActiveMemberCount();
        int expiredCount = memberService.getExpiredMemberCount();

        Map<String, Object> data = new HashMap<>();
        data.put("activeMembers", activeCount);
        data.put("expiredMembers", expiredCount);

        return new Report("membership-report", "Membership", data);
    }

    public Report generateAttendanceReport() {
        List<Member> members = memberService.getAllMembers();
        Map<String, Double> attendancePercentages = new HashMap<>();
        for (Member member : members) {
            double percentage = attendanceService.getAttendancePercentage(member.getId());
            attendancePercentages.put(member.getName(), percentage);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("attendancePercentages", attendancePercentages);

        return new Report("attendance-report", "Attendance", data);
    }

    public Report generateTopPerformersReport() {
        List<WorkoutSchedule> schedules = scheduleService.getAllSchedules();
        Map<String, Long> progressCount = schedules.stream()
                .collect(Collectors.groupingBy(WorkoutSchedule::getMemberId, Collectors.counting()));

        Map<String, Object> data = new HashMap<>();
        data.put("topPerformers", progressCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        return new Report("top-performers-report", "Top Performers", data);
    }

    public void exportReportToCSV(Report report, String filePath) {
        // Simple CSV export logic
        // For brevity, just print to console; in real implementation, write to file
        System.out.println("Exporting report to CSV: " + filePath);
        System.out.println("Type: " + report.getType());
        report.getData().forEach((key, value) -> System.out.println(key + "," + value));
    }
}
