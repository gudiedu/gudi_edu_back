package kr.happyjob.study.aAlert.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.aAlert.model.ASuggestionDTO;

public interface ASuggestionService {
	public List<ASuggestionDTO> searchSuggestion(Map<String, Object> paramMap) throws Exception;
}
