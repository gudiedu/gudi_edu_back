package kr.happyjob.study.information.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @Service
@RequiredArgsConstructor
public class ACourseDTO {
	
	private int course_no;
	private String loginID;
	private int survey_no;
	private String course_subject;
	private String course_name;
	private String course_quota;
	private String course_description;
	private String course_start_date;
	private String course_end_date;
	private String course_loc;

}
