package kr.happyjob.study.support.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoomVO {
	
	private int chat_no;
	private String chat_name;
	private String chat_maker;
	private int count_people;

}
