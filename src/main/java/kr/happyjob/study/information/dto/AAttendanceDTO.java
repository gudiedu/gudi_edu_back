package kr.happyjob.study.information.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class AAttendanceDTO {
	
	private int attendance_no;
	private String loginID;
	private int course_no;
	private int file_no;
	private String attendance_date;
	private String attendance_status;
}
