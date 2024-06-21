package kr.happyjob.study.classroom.model;

public class SSurveyChoiceContentModel {

	private int question_choiced;

	private int choice_no;

	private String choice_result;

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

	public String getChoice_result() {
		return choice_result;
	}

	public void setChoice_result(String choice_result) {
		this.choice_result = choice_result;
	}
}
