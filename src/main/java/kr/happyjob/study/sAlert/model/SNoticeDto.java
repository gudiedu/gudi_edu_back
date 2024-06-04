package kr.happyjob.study.sAlert.model;

public class SNoticeDto {
	
	//유저타입
	private String user_type;
		
	//로그인 ID(작성자)
	private String loginID;
	
	//공지사항 번호
	private int notice_no;
	   
	//파일 번호
	private int file_no;
	   
	//공지사항 제목
	private String notice_title;
	   
	//공지사항 본문
	private String notice_content;
	   
	//작성일
	private String notice_created_at;

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
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
	
	
	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

}