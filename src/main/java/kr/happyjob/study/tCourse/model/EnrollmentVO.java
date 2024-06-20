package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentVO {
	
	private int enrollment_no; //수강번호
	private int course_no; //강의번호
	private String loginID; //아이디
	private int enrollment_confirmed; //승인여부
	
	

}
