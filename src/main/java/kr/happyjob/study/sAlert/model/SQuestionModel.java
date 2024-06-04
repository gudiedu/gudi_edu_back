package kr.happyjob.study.sAlert.model;

public class SQuestionModel {

	private int question_no;
	
	private int course_no;
	
	private String loginID;
	
	private int attachment_no;
	
	private String question_title;
	
	private String question_content;
	
	private String name;
	
	private String question_created_at;

	public int getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(int question_no) {
		this.question_no = question_no;
	}

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

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getQuestion_content() {
		return question_content;
	}

	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion_created_at() {
		return question_created_at;
	}

	public void setQuestion_created_at(String question_created_at) {
		this.question_created_at = question_created_at;
	}
}
