package kr.happyjob.study.classroom.model;

public class STestSubmissionModel {
	
	private int submission_no;
	private int course_no;
	private int test_no;
	private String answer_selected;
	private int result_score;
	
	public int getSubmission_no() {
		return submission_no;
	}
	public void setSubmission_no(int submission_no) {
		this.submission_no = submission_no;
	}
	public int getCourse_no() {
		return course_no;
	}
	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
	public int getTest_no() {
		return test_no;
	}
	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}
	public String getAnswer_selected() {
		return answer_selected;
	}
	public void setAnswer_selected(String answer_selected) {
		this.answer_selected = answer_selected;
	}
	public int getResult_score() {
		return result_score;
	}
	public void setResult_score(int result_score) {
		this.result_score = result_score;
	}

	
	
}
