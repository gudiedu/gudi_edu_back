package kr.happyjob.study.sAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SQnaDto;

public interface SQnaDao {
	
	// Qna 목록 조회
	public List<SQnaDto> sListQna (Map<String, Object> paramMap) throws Exception;

}
