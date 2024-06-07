package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dao.SSuggestionDao;
import kr.happyjob.study.sAlert.dto.SSuggestionDto;

@Service
public class SSuggestionServiceImpl implements SSuggestionService {

	@Autowired
	SSuggestionDao SSuggestionDao;
	
	/** 건의사항 목록 조회 */
	public List<SSuggestionDto> sSuggestionList(Map<String, Object> paramMap) throws Exception {
		return SSuggestionDao.sSuggestionList(paramMap);
	}
	
	/** 건의사항 목록 조회 */
	public SSuggestionDto sSelectSuggestion(Map<String, Object> paramMap) throws Exception {
		return SSuggestionDao.sSelectSuggestion(paramMap);
	}
	
}
