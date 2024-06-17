package kr.happyjob.study.support.dao;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.support.model.tClassSurveyVO;


public interface tClassSurveyDao {
	
	
	public List<tClassSurveyVO> searchClassSurvey(Map<String, Object> paramMap) throws Exception;
	
	public int totalcntClassSurvey(Map<String, Object> paramMap) throws Exception;
	
	public tClassSurveyVO selectClassSurvey(Map<String, Object> paramMap) throws Exception;
	

	
}
