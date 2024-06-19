package kr.happyjob.study.common.socket;

import lombok.Data;

@Data
public class MessageVO {
	
	private String sender;
    private String content;
    private String chatRoomId;

}
