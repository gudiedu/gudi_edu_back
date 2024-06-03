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
	
	private int resource_no;
	private int course_no;
	private String loginID;
	private String resource_title;
	private String resource_content;
	private String resource_created_at;
	private String resource_edited_at;
	private String resouce_writer;
	private String resource_editor;

}
