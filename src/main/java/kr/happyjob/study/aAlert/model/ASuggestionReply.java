package kr.happyjob.study.aAlert.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ASuggestionReply {
	private int suggestion_reply_no;
	private int suggestion_no;
	private String login_ID;
	private String suggestion_reply_content;
	private String suggestion_reply_created_at;
	private int file_no;
}
