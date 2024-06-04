package kr.happyjob.study.classroom.model;

public class SSurveyQuestionModel {

	private int survey_no;
	
	private int survey_question_no;
	
	private boolean survey_question_essential;
	
	private String survey_question_text;
	
	private int survey_question_choiced;
	
	private String survey_question_type;

	public int getSurvey_no() {
		return survey_no;
	}

	public void setSurvey_no(int survey_no) {
		this.survey_no = survey_no;
	}

	public int getSurvey_question_no() {
		return survey_question_no;
	}

	public void setSurvey_question_no(int survey_question_no) {
		this.survey_question_no = survey_question_no;
	}

	public boolean isSurvey_question_essential() {
		return survey_question_essential;
	}

	public void setSurvey_question_essential(boolean survey_question_essential) {
		this.survey_question_essential = survey_question_essential;
	}

	public String getSurvey_question_text() {
		return survey_question_text;
	}

	public void setSurvey_question_text(String survey_question_text) {
		this.survey_question_text = survey_question_text;
	}

	public int getSurvey_question_choiced() {
		return survey_question_choiced;
	}

	public void setSurvey_question_choiced(int survey_question_choiced) {
		this.survey_question_choiced = survey_question_choiced;
	}

	public String getSurvey_question_type() {
		return survey_question_type;
	}

	public void setSurvey_question_type(String survey_question_type) {
		this.survey_question_type = survey_question_type;
	}
	
	
	
}
