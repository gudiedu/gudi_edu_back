package kr.happyjob.study.sAlert.model;

public class SSuggestionReplyModel {

	private int suggestion_reply_no;
	
	private String loginID;
	
	private int suggestion_no;
	
	private String suggestion_reply_content;
	
	private String suggestion_reply_created_at;
	
	private int attachment_no;

	public int getSuggestion_reply_no() {
		return suggestion_reply_no;
	}

	public void setSuggestion_reply_no(int suggestion_reply_no) {
		this.suggestion_reply_no = suggestion_reply_no;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public int getSuggestion_no() {
		return suggestion_no;
	}

	public void setSuggestion_no(int suggestion_no) {
		this.suggestion_no = suggestion_no;
	}

	public String getSuggestion_reply_content() {
		return suggestion_reply_content;
	}

	public void setSuggestion_reply_content(String suggestion_reply_content) {
		this.suggestion_reply_content = suggestion_reply_content;
	}

	public String getSuggestion_reply_created_at() {
		return suggestion_reply_created_at;
	}

	public void setSuggestion_reply_created_at(String suggestion_reply_created_at) {
		this.suggestion_reply_created_at = suggestion_reply_created_at;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

}
