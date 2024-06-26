
package kr.happyjob.study.support.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.support.dao.tClassSurveyDao;
import kr.happyjob.study.support.model.tClassSurveyResultDTO;
import kr.happyjob.study.support.model.tClassSurveyVO;

@Service
public class tClassSurveyServiceImpl implements tClassSurveyService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();


	@Autowired
	tClassSurveyDao tClassSurveyDao;
		

	/** 설문조사 목록 조회 */
	public List<tClassSurveyVO> searchClassSurvey(Map<String, Object> paramMap) throws Exception {

		return tClassSurveyDao.searchClassSurvey(paramMap);
		
	}
	
	
	/** 설문조사 카운트 조회 */
	public int totalcntClassSurvey(Map<String, Object> paramMap) throws Exception {
		 
		return tClassSurveyDao.totalcntClassSurvey(paramMap);
	}

	
	/** 설문조사 하나 조회 */
	public tClassSurveyVO selectClassSurvey(Map<String, Object> paramMap) throws Exception {

		return tClassSurveyDao.selectClassSurvey(paramMap);
	}

	 public List<tClassSurveyResultDTO> fetchSurveyResults(Map<String, Object> paramMap) throws Exception{
	        return tClassSurveyDao.fetchSurveyResults(paramMap);
	    }
	
	
}
