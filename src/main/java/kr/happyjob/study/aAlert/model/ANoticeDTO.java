package kr.happyjob.study.aAlert.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ANoticeDTO {
	
	// 공지사항 번호
	private int notice_no;
	
	//로그인 ID(작성자)
	private String loginID;
	
	//파일 번호
	private int file_no;
	
	//공지사항 제목
	private String notice_title;
	
	//공지사항 본문
	private String notice_content;
	
	//작성일
	private String notice_created_at;
	
	//유저 타입
	private String user_type;
	
}
