package kr.happyjob.study.aAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.ASuggestionDTO;

public interface ASuggestionDAO {
	
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap);
}
