package kr.happyjob.study.support.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.support.model.ChatRoomVO;

public interface ChatRoomService {
	
	public List<ChatRoomVO> ChatRoomList(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> ChatRoomJoin(Map<String, Object> paramMap) throws Exception;
	
	public List<ChatRoomVO> myChatRoomList(Map<String, Object> paramMap) throws Exception;
	
	

	
}
