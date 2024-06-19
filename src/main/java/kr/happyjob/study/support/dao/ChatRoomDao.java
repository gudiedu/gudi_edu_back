package kr.happyjob.study.support.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.support.model.ChatRoomVO;


public interface ChatRoomDao {
	
	
	public List<ChatRoomVO> ChatRoomList(Map<String, Object> paramMap) throws Exception;
	
	public int existChatPeople(Map<String, Object> paramMap) throws Exception;
	
	public List<ChatRoomVO> myChatRoomList(Map<String, Object> paramMap) throws Exception;
	
	public int insertChating(Map<String, Object> paramMap) throws Exception;




}
