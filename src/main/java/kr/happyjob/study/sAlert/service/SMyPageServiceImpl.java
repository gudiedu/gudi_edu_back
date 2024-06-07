package kr.happyjob.study.sAlert.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.sAlert.dao.SMyPageDao;
import kr.happyjob.study.sAlert.dto.SMyPageDto;

@Service
public class SMyPageServiceImpl implements SMyPageService {

	@Autowired
	SMyPageDao SMyPageDao;
	
	/** 내 정보 조회 */
	public SMyPageDto sMyPage(Map<String, Object> paramMap) throws Exception {
		return SMyPageDao.sMyPage(paramMap);
	}
	
	/** 내 정보 수정 */
	public int sUpdateMyPage(Map<String, Object> paramMap) throws Exception{
		return SMyPageDao.sUpdateMyPage(paramMap);
	}
}
