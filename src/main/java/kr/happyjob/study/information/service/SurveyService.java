package kr.happyjob.study.information.service;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.information.model.SurveyModel;
import kr.happyjob.study.information.model.SurveyQuestionModel;

public interface SurveyService {
	public List<SurveyModel> surveyList(Map<String, Object> paramMap) throws Exception;
	
	public List<SurveyQuestionModel> questionList(Map<String, Object> paramMap) throws Exception;
	
}
