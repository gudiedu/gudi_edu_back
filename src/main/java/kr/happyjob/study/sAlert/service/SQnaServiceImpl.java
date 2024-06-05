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

}
