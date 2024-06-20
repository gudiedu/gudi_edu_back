package kr.happyjob.study.support.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class tClassSurveyResultDTO {



		private int course_no;	    
		private int survey_no;
		private int survey_question_no;
	    private String question_choiced;
	    private int choice_no;
	    private String choice_result;
	    private String survey_question_text;
	    private int choice_count;
	    private String written_answer;
	}

