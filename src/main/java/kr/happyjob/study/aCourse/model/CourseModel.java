package kr.happyjob.study.aCourse.model;

import lombok.*;

@Getter
@Setter
public class CourseModel {
	private int course_no;
	private String user_name; //강사명
	private String course_subject; // 강의코드명
	private String course_name; // 강의명
	private int course_quota; // 강의정원
	private String course_description; //강의정보
	private int course_period; //강의 기간
	private String course_start_date; //개강일
	private String course_end_date; //종강일
	private String course_loc; //강의실
}
