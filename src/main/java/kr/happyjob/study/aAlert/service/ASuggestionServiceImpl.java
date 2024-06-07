package kr.happyjob.study.aAlert.service;

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
}
