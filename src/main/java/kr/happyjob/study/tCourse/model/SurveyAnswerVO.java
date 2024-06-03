package kr.happyjob.study.tCourse.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurveyAnswerVO {
	
	private int course_no;
	private String loginID;
	private int survey_no;
	private int survey_question_no;
	private int question_choiced;
	private int choice_no;
	private String written_answer;

}
