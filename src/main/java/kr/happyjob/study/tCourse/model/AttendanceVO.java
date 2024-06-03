package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceVO {
	
	private int attendance_no; //출결번호
	private String loginID; //아이디
	private int course_no; //강의번호
	private int file_no; //파일번호
	private String attendance_date; //출결일자
	private String attendance_status; //출결상태

}
