package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourceVO {
	
	// 학습자료
	
	private int resource_no; // 자료번호
	private int course_no; // 강의번호
	private String loginID; // 아이디
	private String resource_title; // 제목
	private String resource_content; // 내용
	private String resource_created_at; // 등록일자
	private String resource_edited_at; // 수정일자
	private String resouce_writer; // 등록자
	private String resource_editor; // 수정자
	private int file_no; // 파일번호

}
