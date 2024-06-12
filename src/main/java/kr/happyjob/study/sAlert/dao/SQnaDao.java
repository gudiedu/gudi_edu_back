package kr.happyjob.study.sAlert.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.sAlert.dto.SQnaDto;

public interface SQnaDao {
	
	// Qna 목록 조회
	public List<SQnaDto> sQnaList (Map<String, Object> paramMap) throws Exception;

	// Qna 1건 조회
	public SQnaDto sQnaSelected(Map<String, Object> paramMap) throws Exception;

	// Qna 목록 카운트 조회
	public int totalCountQna(Map<String, Object> paramMap) throws Exception;

	// Qna 게시글 등록
	public int sQnaInsert(Map<String, Object> paramMap) throws Exception;

	//Qna 게시글 삭제
	public int sQnaDelete(Map<String, Object> paramMap) throws Exception;

	// Qna 답변 조회
	public List<SQnaDto> sQnaSelectedReply(Map<String, Object> paramMap);

	// 학생이 수강신청한 강의 목록
	public List<SQnaDto> enrolledCourse(Map<String, Object> paramMap);

	
}
