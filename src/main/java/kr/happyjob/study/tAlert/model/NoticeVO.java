package kr.happyjob.study.tAlert.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeVO {


		private int notice_no;
		private String loginID;
		private int file_no;
		private String notice_title;
		private String notice_content;
		private String notice_created_at;
		private String user_type;
		
	}

