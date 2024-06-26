package kr.happyjob.study.tCourse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LearningMaterialsDTO {
	
	// 학습자료
	private int resource_no; // 자료번호
	private int course_no; // 강의번호
	private String course_name; // 강의이름
	private String loginID; // 아이디
	private String name; 
	private String resource_title; // 제목
	private String resource_content; // 내용
	private String resource_created_at; // 등록일자
	private String resource_writer; // 등록자
	private String resource_edited_at; // 수정일자
	private String resource_editor; // 수정자
	private int file_no; // 파일번호
	
    private String file_server_path; // 서버 경로
    private String file_local_path; // 로컬 경로
    private String file_origin; // 원본 파일 이름
    private String file_rename; // 변경된 파일 이름
    private String file_extension; // 파일 확장자
    private int file_size; // 파일 크기

}
