package kr.happyjob.study.aAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.ASuggestionDTO;

public interface ASuggestionDAO {
	
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> selectSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> selectSuggestionReply(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> downloadFile(Map<String, Object> paramMap) throws Exception;
}
