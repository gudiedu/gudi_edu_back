package kr.happyjob.study.support.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.happyjob.study.support.dao.ChatRoomDao;
import kr.happyjob.study.support.model.ChatRoomVO;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
	
	@Autowired
	ChatRoomDao chatRoomDao;

	@Override
	public List<ChatRoomVO> ChatRoomList(Map<String, Object> paramMap) throws Exception {
		return chatRoomDao.ChatRoomList(paramMap);
	}

	@Override
	public Map<String, Object> ChatRoomJoin(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> returnmap = new HashMap<>();
		
		int count = chatRoomDao.existChatPeople(paramMap);
		
		if (count <= 0) {
			chatRoomDao.insertChating(paramMap);
		}
		
//		returnmap.put("mychatlist", chatRoomDao.myChatRoomList(paramMap)); 
		
		return returnmap;
	}

	@Override
	public List<ChatRoomVO> myChatRoomList(Map<String, Object> paramMap) throws Exception {
		return chatRoomDao.myChatRoomList(paramMap);
	}
	
	

}
