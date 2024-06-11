package kr.happyjob.study.aAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.AFileDTO;
import kr.happyjob.study.aAlert.model.ASuggestionDTO;

public interface ASuggestionDAO {
	
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> selectSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> selectSuggestionReply(Map<String, Object> paramMap) throws Exception;
	
	public int insertReply(Map<String, Object> paramMap);
	
	public int updateReply(Map<String, Object> paramMap);
	
	public int deleteReply(Map<String, Object> paramMap);
	
	public int deleteSuggestion(Map<String, Object> paramMap);
	
	public int updateSuggestion(Map<String, Object> paramMap);
	
	public int saveFile(AFileDTO file);
	
	public Map<String, Object> downloadFile(Map<String, Object> paramMap) throws Exception;
}
