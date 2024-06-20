package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestExamVO {
	
	private int course_no; // 강의번호
	private int test_no; // 문제번호
	private String test_question; // 문제
	private String test_choice1; // 선택지1
	private String test_choice2; // 선택지2
	private String test_choice3; // 선택지3
	private String test_choice4; // 선택지4
	private String test_answer; // 정답
	private String test_score; // 배점
	private String test_category;
	
}
