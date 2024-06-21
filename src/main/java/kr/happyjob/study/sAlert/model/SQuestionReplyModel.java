package kr.happyjob.study.sAlert.model;

public class SQuestionReplyModel {

	private int reply_no;
	
	private int question_no;
	
	private String loginID;
	
	private int category_no;
	
	private int attachment_no;
	
	private String reply_content;
	
	private String name;
	
	private String reply_created_at;

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public int getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(int question_no) {
		this.question_no = question_no;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReply_created_at() {
		return reply_created_at;
	}

	public void setReply_created_at(String reply_created_at) {
		this.reply_created_at = reply_created_at;
	}
}
