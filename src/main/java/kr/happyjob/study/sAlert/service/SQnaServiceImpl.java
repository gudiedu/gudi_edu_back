package kr.happyjob.study.sAlert.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dao.SQnaDao;
import kr.happyjob.study.sAlert.dto.SQnaDto;

@Service
public class SQnaServiceImpl implements SQnaService {

	@Autowired
	SQnaDao sQnaDao;
	
	// Qna 목록 조회
	public List<SQnaDto> sListQna(Map<String, Object> paramMap) throws Exception {
		
		return sQnaDao.sListQna(paramMap);
	}
	
	// Qna 1건 조회
	public SQnaDto sSelectedQna(Map<String, Object> paramMap) throws Exception {
		
		return sQnaDao.sSelectedQna(paramMap);
	}
	
	// Qna 목록 카운트 조회
	public int totalCountQna(Map<String, Object> paramMap) throws Exception{
		
		return sQnaDao.totalCountQna(paramMap);
	
	}
	
	// Qna 등록
		public int insertQna(Map<String, Object> paramMap) throws Exception{
			
			return sQnaDao.insertQna(paramMap);
		}

	//Qna 삭제
	public int deleteQna(Map<String, Object> paramMap) throws Exception{
		
		return sQnaDao.deleteQna(paramMap);
		
	}

}
