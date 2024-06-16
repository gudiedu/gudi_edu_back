package kr.happyjob.study.information.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyQuestionModel {
	private int survey_no;
	private int survey_question_no;
	private int survey_question_essential;
	private String survey_question_text;
	private int question_choiced;
	private String survey_question_type;

}
