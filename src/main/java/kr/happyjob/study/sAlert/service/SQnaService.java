package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.sAlert.dto.SQnaDto;

public interface SQnaService {

	// Qna 목록 조회
	public List<SQnaDto> sQnaList(Map<String, Object> paramMap) throws Exception;

	// Qna 목록 갯수 조회
	public int totalCountQna(Map<String, Object> paramMap) throws Exception;
	
	// Qna 1건 세부 조회
	public SQnaDto sQnaSelected(Map<String, Object> paramMap) throws Exception;

	// Qna 등록
	public int sQnaInsert(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;

	//Qna 삭제
	public int sQnaDelete(Map<String, Object> paramMap) throws Exception;

	// Qna 답변 조회
	public List<SQnaDto> sQnaSelectedReply(Map<String, Object> paramMap) throws Exception;

	// 학생의 수강신청한 강의 목록 조회
	public List<SQnaDto> sQnaGetCourseName(Map<String, Object> paramMap) throws Exception;

}
