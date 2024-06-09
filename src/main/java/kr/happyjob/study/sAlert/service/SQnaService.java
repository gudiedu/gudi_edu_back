package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SQnaDto;

public interface SQnaService {

	// Qna 목록 조회
	public List<SQnaDto> sListQna(Map<String, Object> paramMap) throws Exception;

	// Qna 목록 갯수 조회
	public int totalCountQna(Map<String, Object> paramMap) throws Exception;
	
	// Qna 1건 세부 조회
	public SQnaDto sSelectedQna(Map<String, Object> paramMap) throws Exception;

	// Qna 등록
	public int insertQna(Map<String, Object> paramMap) throws Exception;

	//Qna 삭제
	public int deleteQna(Map<String, Object> paramMap) throws Exception;


}
