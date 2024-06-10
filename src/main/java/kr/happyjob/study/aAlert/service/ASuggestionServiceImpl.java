package kr.happyjob.study.aAlert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.happyjob.study.aAlert.dao.ASuggestionDAO;
import kr.happyjob.study.aAlert.model.ASuggestionDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ASuggestionServiceImpl implements ASuggestionService{
	
	private final ASuggestionDAO aSuggestionDAO;
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Override
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap) throws Exception {
		return aSuggestionDAO.searchSuggestion(paramMap);
	}
	
	@Override
	public Map<String, Object> selectSuggestion(Map<String, Object> paramMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> suggestionReply = new HashMap<>();
		Map<String, Object> suggestion = aSuggestionDAO.selectSuggestion(paramMap);
		
		if(paramMap.get("suggestion_answered").toString().equals("Y")){
			suggestionReply = aSuggestionDAO.selectSuggestionReply(paramMap);
		}
		
		resultMap.put("suggestion", suggestion);
		resultMap.put("suggestionReply", suggestionReply);
		
		logger.info(resultMap);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> downloadFile(Map<String, Object> paramMap) throws Exception {
		return aSuggestionDAO.downloadFile(paramMap);
	}
}
