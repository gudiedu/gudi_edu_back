package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDTO {
	
	private int course_no;
	private int test_no;
	private String test_question;
	private String test_choice1;
	private String test_choice2;
	private String test_choice3;
	private String test_choice4;
	private String test_answer;

}
