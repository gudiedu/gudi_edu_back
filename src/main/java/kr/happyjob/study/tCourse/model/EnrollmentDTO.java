package kr.happyjob.study.tCourse.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentDTO {
	
	private int enrollment_no; //수강번호
	private int course_no; //강의번호
	private String loginID; //아이디
	private String enrollment_confirmed; //승인여부
	private String name;
	private String email;
	private String hp;
	private String survey_exists;
	private int grade;
	private String attendance_date;
	private int attendance_no;
	private String attendance_status;
	private int totalDays;
	private Map<String, String> attendance = new HashMap<>();

	public EnrollmentDTO(String name, String hp, int totalDays) {
		this.name = name;
		this.hp = hp;
		this.attendance = new HashMap<>();
		this.totalDays = totalDays;
	}
	
	public void addAttendance(String date, String status) {
		attendance.put(date, status);
	}
	
	public String attendanceStatus(String date) {
        return attendance.getOrDefault(date, "");
    }
	
	public String attendanceRate() {
        long presentCount = attendance.values().stream().filter(status -> "출석".equals(status)).count();
        return String.format("%.2f%%", (presentCount / (double) totalDays) * 100);
    }

}
