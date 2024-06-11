package kr.happyjob.study.aAlert.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.aAlert.model.ASuggestionDTO;

public interface ASuggestionService {
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> selectSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> downloadFile(Map<String,Object> paramMap) throws Exception;
	
	public int insertReply(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	public int updateReply(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	public int deleteReply(Map<String, Object> paramMap) throws Exception;
	
	public int deleteSuggestion(Map<String, Object> paramMap) throws Exception;
}
