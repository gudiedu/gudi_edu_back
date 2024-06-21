package kr.happyjob.study.classroom.model;

public class SSurveyAnswerModel {

	private int course_no;
	
	private String loginID;
	
	private int survey_no;
	
	private int survey_question_no;
	
	private int question_choiced;
	
	private int choice_no;
	
	private String written_anwers;
	
	private String survey_completed;

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

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

	public int getQuestion_choiced() {
		return question_choiced;
	}

	public void setQuestion_choiced(int question_choiced) {
		this.question_choiced = question_choiced;
	}

	public int getChoice_no() {
		return choice_no;
	}

	public void setChoice_no(int choice_no) {
		this.choice_no = choice_no;
	}

	public String getWritten_anwers() {
		return written_anwers;
	}

	public void setWritten_anwers(String written_anwers) {
		this.written_anwers = written_anwers;
	}

	public String getSurvey_completed() {
		return survey_completed;
	}

	public void setSurvey_completed(String survey_completed) {
		this.survey_completed = survey_completed;
	}
	
}
