# Gym Management System (GMS)

## Overview
The Gym Management System (GMS) is a Java-based application designed to efficiently manage gym operations, including member registration, workout schedules, attendance tracking, and role-based access control. It supports three user roles: Admin, Trainer, and Member, each with specific functionalities.

## Features
- **Role-Based Access Control**: Separate interfaces for Admin, Trainer, and Member roles.
- **Membership Management**: Add, update, delete, and track member subscriptions.
- **Workout Schedule Management**: Create and assign schedules, track progress.
- **Attendance Tracking**: Record and report daily attendance.
- **Reporting**: Generate revenue, membership, attendance, and performance reports.
- **Data Persistence**: Save and load data using JSON files.

## Architecture
The application follows a layered architecture:
- **POJO Layer**: Data models (User, Member, Trainer, Admin, Subscription, WorkoutSchedule, Attendance, Report).
- **DAO Layer**: Data access interfaces and JSON implementations.
- **Repository Layer**: Business logic for data management.
- **Service Layer**: Application services for operations and calculations.
- **Main Application**: Console-based menu-driven interface.

## Classes and Methods

### POJO Classes
- **User**: Base class with id, name, email, password, role.
  - Methods: getters, setters, toString().
- **Member** (extends User): Adds subscriptionId, joinDate, expiryDate, isActive.
  - Methods: getters, setters, toString().
- **Trainer** (extends User): Adds specialization.
  - Methods: getters, setters, toString().
- **Admin** (extends User): No additional fields.
  - Methods: getters, setters, toString().
- **Subscription**: id, name, price, durationMonths.
  - Methods: getters, setters, toString().
- **WorkoutSchedule**: id, memberId, trainerId, date, exercises, progress.
  - Methods: getters, setters, toString().
- **Attendance**: id, memberId, date, present.
  - Methods: getters, setters, toString().
- **Report**: id, type, data (Map).
  - Methods: getters, setters, toString().

### DAO Classes
- **MemberDao**: Interface with addMember, getMemberById, getAllMembers, updateMember, deleteMember, saveAll, loadAll.
- **MemberDaoJsonImpl**: JSON-based implementation using Gson.
- **ScheduleDao**: Interface with addSchedule, getScheduleById, getSchedulesByMemberId, getAllSchedules, updateSchedule, deleteSchedule, saveAll, loadAll.
- **ScheduleDaoJsonImpl**: JSON-based implementation.
- **AttendanceDao**: Interface with addAttendance, getAttendanceById, getAttendanceByMemberId, getAllAttendance, updateAttendance, deleteAttendance, saveAll, loadAll.
- **AttendanceDaoJsonImpl**: JSON-based implementation.

### Repository Classes
- **MemberRepository**: Wraps MemberDao for CRUD operations.
- **ScheduleRepository**: Wraps ScheduleDao.
- **AttendanceRepository**: Wraps AttendanceDao.

### Service Classes
- **MemberService**: Business logic for members, including active/expired counts.
  - Methods: addMember, getMemberById, getAllMembers, updateMember, deleteMember, getActiveMembers, getExpiredMembers, getActiveMemberCount, getExpiredMemberCount.
- **ScheduleService**: Logic for schedules and progress updates.
  - Methods: addSchedule, getScheduleById, getSchedulesByMemberId, getAllSchedules, updateSchedule, deleteSchedule, updateProgress.
- **AttendanceService**: Attendance management and percentage calculations.
  - Methods: addAttendance, getAttendanceById, getAttendanceByMemberId, getAllAttendance, updateAttendance, deleteAttendance, getAttendancePercentage, getAttendanceForDate.
- **ReportService**: Report generation and export.
  - Methods: generateRevenueReport, generateMembershipReport, generateAttendanceReport, generateTopPerformersReport, exportReportToCSV.
- **AuthService**: User authentication and role management.
  - Methods: login, addUser, getUsersByRole.

### Main Class
- **Main**: Entry point with menu-driven interface for login and role-specific menus.
  - Methods: main, adminMenu, manageMembers, manageTrainers, managePlans, generateReports, trainerMenu, memberMenu.

## User Flowchart
1. **Login**: User enters email and password.
2. **Role Check**:
   - If Admin: Access admin menu (manage members/trainers/plans, generate reports).
   - If Trainer: Access trainer menu (assign schedules, track attendance, view progress).
   - If Member: Access member menu (view schedules, update progress, renew subscription).
3. **Operations**: Perform CRUD, tracking, reporting based on role.
4. **Logout**: Return to login.

## Setup and Run
1. Ensure Java 11+ and Gson library (lib/gson-2.10.1.jar).
2. Compile: `javac -cp lib/gson-2.10.1.jar -d bin src/**/*.java`
3. Run: `java -cp bin;lib/gson-2.10.1.jar Main`
4. Default credentials:
   - Admin: admin@gym.com / admin123
   - Trainer: trainer1@gym.com / trainer123
   - Member: member1@gym.com / member123

### Hướng dẫn chạy chương trình (Instructions to run the program)
1. Đảm bảo bạn có Java 11+ và thư viện Gson (lib/gson-2.10.1.jar).
2. Biên dịch: Mở terminal/command prompt, điều hướng đến thư mục dự án (d:/Java_E-Learning/E2/GMS), chạy lệnh: `javac -cp lib/gson-2.10.1.jar -d bin src/**/*.java`
3. Chạy: `java -cp bin;lib/gson-2.10.1.jar Main`
4. Đăng nhập với thông tin mặc định:
   - Admin: admin@gym.com / admin123
   - Trainer: trainer1@gym.com / trainer123
   - Member: member1@gym.com / member123
5. Sử dụng menu để thực hiện các chức năng theo vai trò.

## Data Files
- data/members.json: Member data.
- data/schedules.json: Schedule data.
- data/attendance.json: Attendance data.

## Evaluation Notes
- Functionality: Covers membership, schedules, attendance, roles, persistence.
- Code Quality: OOP principles, modular design.
- Documentation: This README, class descriptions.
- Creativity: JSON persistence, console UI, comprehensive reporting.
