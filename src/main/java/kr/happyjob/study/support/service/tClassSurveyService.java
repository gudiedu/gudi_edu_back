package kr.happyjob.study.support.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.support.model.tClassSurveyVO;

public interface tClassSurveyService {
	
	
	/** 공지사항 목록 조회 */
	public List<tClassSurveyVO> searchClassSurvey(Map<String, Object> paramMap) throws Exception;
	
	/**공지사항 카운트*/
	public int totalcntClassSurvey(Map<String, Object> paramMap) throws Exception;
	
	/** 공지사항 한건조회 */
	public tClassSurveyVO selectClassSurvey(Map<String, Object> paramMap) throws Exception;
	



}