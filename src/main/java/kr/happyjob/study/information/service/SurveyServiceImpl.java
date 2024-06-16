package kr.happyjob.study.information.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.information.dao.SurveyDao;
import kr.happyjob.study.information.model.SurveyModel;
import kr.happyjob.study.information.model.SurveyQuestionModel;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	private SurveyDao surveyDao;
	
	@Override
	public List<SurveyModel> surveyList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return surveyDao.surveyList(paramMap);
	}
	
	@Override
	public List<SurveyQuestionModel> questionList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return surveyDao.questionList(paramMap);
	}
}
