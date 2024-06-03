package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDetailDTO {
	
	private int course_detail_no; //강의주차수번호
	private int course_no; //강의번호
	private int course_detail_week_no; //주차수
	private String course_detail_goal; //학습목표
	private String course_detail_content; //학습내용
	
	
	

}
