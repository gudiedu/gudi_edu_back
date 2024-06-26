package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseVO {

	private int course_no; // 강의번호
	private String loginID; // 아이디
	private int survey_no; // 설문코드
	private String course_subject; // 강의과목
	private String course_name; // 과목명
	private int course_quota; // 수강정원
	private String course_description; // 강의소개
	private String course_start_date; // 개강일
	private String course_end_date; // 종강일

	private String course_loc; //강의실
	
	private int duration; // 수강기간
	private String detail_code; // 과목코드
	private int countstudent; //수강현재인원
	
	private int days_elapsed; // 수강한기간
	private double progress; // 진행률
	
	


}
