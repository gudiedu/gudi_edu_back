package kr.happyjob.study.sAlert.model;

public class SSuggestionModel {

	private int suggestion_no;
	
	private String loginID;
	
	private String suggestion_category;
	
	private boolean suggestion_answered;
	
	private String suggestion_title;
	
	private String suggestion_content;
	
	private String suggestion_created_at;
	
	private int attachment_no;

	public int getSuggestion_no() {
		return suggestion_no;
	}

	public void setSuggestion_no(int suggestion_no) {
		this.suggestion_no = suggestion_no;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getSuggestion_category() {
		return suggestion_category;
	}

	public void setSuggestion_category(String suggestion_category) {
		this.suggestion_category = suggestion_category;
	}

	public boolean isSuggestion_answered() {
		return suggestion_answered;
	}

	public void setSuggestion_answered(boolean suggestion_answered) {
		this.suggestion_answered = suggestion_answered;
	}

	public String getSuggestion_title() {
		return suggestion_title;
	}

	public void setSuggestion_title(String suggestion_title) {
		this.suggestion_title = suggestion_title;
	}

	public String getSuggestion_content() {
		return suggestion_content;
	}

	public void setSuggestion_content(String suggestion_content) {
		this.suggestion_content = suggestion_content;
	}

	public String getSuggestion_created_at() {
		return suggestion_created_at;
	}

	public void setSuggestion_created_at(String suggestion_created_at) {
		this.suggestion_created_at = suggestion_created_at;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}
}
