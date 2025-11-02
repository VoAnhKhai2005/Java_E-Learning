# Gym Management System (GMS) Implementation TODO

## 1. Setup Project Structure
- [x] Create data/ folder for JSON persistence files
- [x] Download Gson JAR and add to lib/ folder

## 2. Create POJOs (src/pojo/)
- [x] User.java (base class for roles)
- [x] Member.java (extends User)
- [x] Trainer.java (extends User)
- [x] Admin.java (extends User)
- [x] Subscription.java
- [x] WorkoutSchedule.java
- [x] Attendance.java
- [x] Report.java

## 3. Create DAO Layer (src/dao/)
- [x] MemberDao.java (interface)
- [x] MemberDaoJsonImpl.java (implementation)
- [x] ScheduleDao.java (interface)
- [x] ScheduleDaoJsonImpl.java (implementation)
- [x] AttendanceDao.java (interface)
- [x] AttendanceDaoJsonImpl.java (implementation)

## 4. Create Repository Layer (src/repository/)
- [x] MemberRepository.java
- [x] ScheduleRepository.java
- [x] AttendanceRepository.java

## 5. Create Service Layer (src/service/)
- [x] MemberService.java
- [x] ScheduleService.java
- [x] AttendanceService.java
- [x] ReportService.java
- [x] AuthService.java (for role-based login)

## 6. Implement Main Application (src/Main.java)
- [x] Role-based login system
- [x] Admin menu (manage members, trainers, plans, reports)
- [x] Trainer menu (assign schedules, track attendance)
- [x] Member menu (view schedules, update progress, renew subscriptions)

## 7. Testing and Validation
- [x] Compile and run the application
- [x] Test data persistence (save/load JSON)
- [x] Test role-based access
- [x] Test calculations (revenue, attendance percentages, etc.)
- [x] Test CRUD operations

## 8. Documentation and Screenshots
- [x] Create flowchart description for user interactions
- [x] Document classes and methods
- [ ] Take screenshots of role-based interactions, schedule creation, and attendance tracking
