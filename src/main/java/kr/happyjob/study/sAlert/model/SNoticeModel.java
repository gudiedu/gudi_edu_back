package kr.happyjob.study.sAlert.model;

public class SNoticeModel {

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_created_at() {
		return notice_created_at;
	}

	public void setNotice_created_at(String notice_created_at) {
		this.notice_created_at = notice_created_at;
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

	private int notice_no;
	
	private String notice_title;
	
	private String notice_content;
	
	private String notice_created_at;
	
	private String loginID;
	
	private int attachment_no;
}
