package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestSubmissionVO {
	
	private int submission_no;
	private int course_no;
	private int test_no;
	private String answer_selected;
	private int result_score;
	private String loginID;

}
