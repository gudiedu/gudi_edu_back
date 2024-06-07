package kr.happyjob.study.aAlert.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ASuggestionDTO {
	private int suggestion_no;
	private String loginID;
	private String suggestion_category;
	private String suggestion_answered;
	private String suggestion_title;
	private String suggestion_content;
	private String suggestion_create_at;
	private int file_no;
}
