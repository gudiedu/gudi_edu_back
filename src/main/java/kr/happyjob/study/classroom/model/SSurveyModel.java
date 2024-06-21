package kr.happyjob.study.classroom.model;

public class SSurveyModel {

	private int survey_no;
	
	private String survey_name;
	
	private int total_questions;
	
	private int choice_questions;
	
	private int written_questions;

	public int getSurvey_no() {
		return survey_no;
	}

	public void setSurvey_no(int survey_no) {
		this.survey_no = survey_no;
	}

	public String getSurvey_name() {
		return survey_name;
	}

	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}

	public int getTotal_questions() {
		return total_questions;
	}

	public void setTotal_questions(int total_questions) {
		this.total_questions = total_questions;
	}

	public int getChoice_questions() {
		return choice_questions;
	}

	public void setChoice_questions(int choice_questions) {
		this.choice_questions = choice_questions;
	}

	public int getWritten_questions() {
		return written_questions;
	}

	public void setWritten_questions(int written_questions) {
		this.written_questions = written_questions;
	}
	
	
}
