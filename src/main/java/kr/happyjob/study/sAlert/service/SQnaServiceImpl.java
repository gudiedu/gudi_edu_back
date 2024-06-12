package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dao.SQnaDao;
import kr.happyjob.study.sAlert.dto.SQnaDto;

@Service
public class SQnaServiceImpl implements SQnaService {

	@Autowired
	SQnaDao sQnaDao;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Qna 목록 조회
	public List<SQnaDto> sQnaList(Map<String, Object> paramMap) throws Exception {
		
		return sQnaDao.sQnaList(paramMap);
	}
	
	// Qna 1건 조회
	public SQnaDto sQnaSelected(Map<String, Object> paramMap) throws Exception {
		
		return sQnaDao.sQnaSelected(paramMap);
	}
	
	// Qna 목록 카운트 조회
	public int totalCountQna(Map<String, Object> paramMap) throws Exception{
		
		return sQnaDao.totalCountQna(paramMap);
	
	}
	
	// Qna 등록
	public int sQnaInsert(Map<String, Object> paramMap, HttpServletRequest request) throws Exception{
			
			return sQnaDao.sQnaInsert(paramMap);
		}

	//Qna 삭제
	public int sQnaDelete(Map<String, Object> paramMap) throws Exception{
		
		return sQnaDao.sQnaDelete(paramMap);
		
	}
	
	// Qna 답변 조회
	public List<SQnaDto> sQnaSelectedReply(Map<String, Object> paramMap) throws Exception{
		
		return sQnaDao.sQnaSelectedReply(paramMap);
	}

	// 학생의 수강신청한 강의 목록 조회
		public List<SQnaDto> enrolledCourse(Map<String, Object> paramMap) throws Exception{
			
			return sQnaDao.enrolledCourse(paramMap);
		}

}
