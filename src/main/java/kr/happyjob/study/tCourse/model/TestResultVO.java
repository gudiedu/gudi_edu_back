package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestResultVO {
	
	private int result_no; //시험결과번호
	private int course_no; // 강의번호
	private String loginID; // 아이디
	private int result_score; // 총 점수

}
